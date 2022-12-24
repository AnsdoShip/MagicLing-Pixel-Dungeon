/*
 * Pixel Dungeon
 * Copyright (C) 2012-2015 Oleg Dolya
 *
 * Shattered Pixel Dungeon
 * Copyright (C) 2014-2021 Evan Debenham
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
import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Buff;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.HalomethaneBurning;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Vertigo;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;
import com.watabou.utils.Random;

public class Gauntlet extends MeleeWeapon {

  {
    image = ItemSpriteSheet.GAUNTLETS;
    hitSound = Assets.Sounds.HIT_CRUSH;
    hitSoundPitch = 1.2f;

    tier = 3;
    DLY = 0.25f; // 2x speed
  }

  @Override
  public int defenseFactor(Char owner) {
    return 6 + 3 * buffedLvl(); // 6 extra defence, plus 3 per level;
  }

  @Override
  public int max(int lvl) {

    return Math.round(2.5f * (tier + 1))
        + // 15 base, down from 30
        lvl * Math.round(0.5f * (tier + 1)); // +3 per level, down from +6
  }

  @Override
  public int proc(Char attacker, Char defender, int damage) {
    switch (Random.Int(6)) {
      case 0:
      case 1:
      case 2:
      case 3:
      default:
        return max(buffedLvl());
      case 4:
      case 5:
        Buff.affect(defender, HalomethaneBurning.class).reignite(defender);
        if (Random.Float() < 0.55f && level < 3) {
          Buff.prolong(attacker, Vertigo.class, 3f);
        }
        return max(buffedLvl());
    }
  }

  public String statsInfo() {
    if (isIdentified()) {
      return Messages.get(this, "stats_desc", 1 + 1 * buffedLvl());
    } else {
      return Messages.get(this, "typical_stats_desc", 1);
    }
  }
}
