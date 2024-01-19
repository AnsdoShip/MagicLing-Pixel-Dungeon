/*
 * Pixel Dungeon
 * Copyright (C) 2012-2015 Oleg Dolya
 *
 * Shattered Pixel Dungeon
 * Copyright (C) 2014-2024 Evan Debenham
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

package com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee;

import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.Actor;
import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Buff;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Invisibility;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.sprites.CharSprite;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSprite;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;
import com.shatteredpixel.shatteredpixeldungeon.ui.AttackIndicator;
import com.shatteredpixel.shatteredpixeldungeon.ui.BuffIndicator;
import com.shatteredpixel.shatteredpixeldungeon.utils.GLog;
import com.watabou.noosa.MovieClip;
import com.watabou.noosa.TextureFilm;
import com.watabou.noosa.audio.Sample;
import com.watabou.utils.Bundle;
import com.watabou.utils.Callback;
import com.watabou.utils.Random;

public class Sai extends MeleeWeapon {
	public int R;
	{
		image = ItemSpriteSheet.SAI;
		hitSound = Assets.Sounds.HIT_STAB;
		hitSoundPitch = 1.3f;
		tier = 3;
		DLY = 0.5f; //2x speed
	}

	@Override
	public ItemSprite.Glowing glowing() {
		return new ItemSprite.Glowing(0x880000, 6f);
	}

	public String statsInfo(){
		return (Messages.get(this,"stats_info",R));
	}


	@Override
	public int proc(Char attacker, Char defender, int damage ) {
		switch (Random.Int(7)) {
			case 0:case 1:case 2:case 3:case 4:
			default:
				return super.proc(attacker, defender, damage);
			case 5:case 6:case 7:
				//角色最大血量*0.1+武器等级*0.5+1.5
				//50x0.1+7x0.5+1=10+3.5+1=15
				if(attacker.HP >= attacker.HT){
					GLog.p(Messages.get(this,"full"));
				} else if (Random.Int(10)<=4) {
					R = (int) Math.min(attacker.HT-attacker.HP,(attacker.HT * 0.1 + (buffedLvl() * 0.5) + 1.5));
					attacker.HP +=R;
					attacker.sprite.showStatus(CharSprite.POSITIVE, ("+" + R + "HP"));
					GLog.p(Messages.get(this,"success",attacker.name()));
				}
				return super.proc(attacker, defender, damage);
		}
	}


	@Override
	public int max(int lvl) {
		return  Math.round(1.2f*(tier+1)) +     //10 base, down from 20
				lvl*Math.round(1.2f*(tier+1));  //+2 per level, down from +4
	}

	@Override
	public int min(int lvl) {
		return  Math.round(0.74f*(tier+1)) +     //10 base, down from 20
				lvl*Math.round(0.65f*(tier+1));  //+2 per level, down from +4
	}

	//TODO 武技
	@Override
	public String targetingPrompt() {
		return Messages.get(this, "prompt");
	}

	@Override
	protected void duelistAbility(Hero hero, Integer target) {
		Sai.comboStrikeAbility(hero, target, 0.40f, this);
	}

	public static void comboStrikeAbility(Hero hero, Integer target, float boostPerHit, MeleeWeapon wep){
		if (target == null) {
			return;
		}

		Char enemy = Actor.findChar(target);
		if (enemy == null || enemy == hero || hero.isCharmedBy(enemy) || !Dungeon.level.heroFOV[target]) {
			GLog.w(Messages.get(wep, "ability_no_target"));
			return;
		}

		hero.belongings.abilityWeapon = wep;
		if (!hero.canAttack(enemy)){
			GLog.w(Messages.get(wep, "ability_bad_position"));
			hero.belongings.abilityWeapon = null;
			return;
		}
		hero.belongings.abilityWeapon = null;

		hero.sprite.attack(enemy.pos, new Callback() {
			@Override
			public void call() {
				wep.beforeAbilityUsed(hero, enemy);
				AttackIndicator.target(enemy);

				int recentHits = 0;
				ComboStrikeTracker buff = hero.buff(ComboStrikeTracker.class);
				if (buff != null){
					recentHits = buff.totalHits();
					buff.detach();
				}

				boolean hit = hero.attack(enemy, 1f + boostPerHit*recentHits, 0, Char.INFINITE_ACCURACY);
				if (hit && !enemy.isAlive()){
					wep.onAbilityKill(hero, enemy);
				}

				Invisibility.dispel();
				hero.spendAndNext(hero.attackDelay());
				if (recentHits >= 2 && hit){
					Sample.INSTANCE.play(Assets.Sounds.HIT_STRONG);
				}

				wep.afterAbilityUsed(hero);
			}
		});
	}

	public static class ComboStrikeTracker extends Buff {

		{
			type = buffType.POSITIVE;
		}

		public static int DURATION = 6; //to account for the turn the attack is made in
		public int[] hits = new int[DURATION];

		@Override
		public int icon() {
			//pre-v2.1 saves
			if (totalHits() == 0) return BuffIndicator.NONE;

			if (Dungeon.hero.belongings.weapon() instanceof Gloves
					|| Dungeon.hero.belongings.weapon() instanceof Sai
					|| Dungeon.hero.belongings.weapon() instanceof Gauntlet
					|| Dungeon.hero.belongings.secondWep() instanceof Gloves
					|| Dungeon.hero.belongings.secondWep() instanceof Sai
					|| Dungeon.hero.belongings.secondWep() instanceof Gauntlet) {
				return BuffIndicator.DUEL_COMBO;
			} else {
				return BuffIndicator.NONE;
			}
		}

		@Override
		public boolean act() {

			//shuffle all hits down one turn
			for (int i = 0; i < DURATION; i++){
				if (i == DURATION-1){
					hits[i] = 0;
				} else {
					hits[i] =  hits[i+1];
				}
			}

			if (totalHits() == 0){
				detach();
			}

			spend(TICK);
			return true;
		}

		public void addHit(){
			hits[DURATION-1]++;
		}

		public int totalHits(){
			int sum = 0;
			for (int i = 0; i < DURATION; i++){
				sum += hits[i];
			}
			return sum;
		}

		@Override
		public String iconTextDisplay() {
			return Integer.toString(totalHits());
		}

		@Override
		public String desc() {
			return Messages.get(this, "desc", totalHits());
		}

		public static String RECENT_HITS = "recent_hits";

		@Override
		public void storeInBundle(Bundle bundle) {
			super.storeInBundle(bundle);
			bundle.put(RECENT_HITS, hits);
		}

		@Override
		public void restoreFromBundle(Bundle bundle) {
			super.restoreFromBundle(bundle);
			if (bundle.contains(RECENT_HITS)) {
				hits = bundle.getIntArray(RECENT_HITS);
			}
		}
	}

}
