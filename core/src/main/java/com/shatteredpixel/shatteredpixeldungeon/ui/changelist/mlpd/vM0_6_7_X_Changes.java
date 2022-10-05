package com.shatteredpixel.shatteredpixeldungeon.ui.changelist.mlpd;

import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.scenes.ChangesScene;
import com.shatteredpixel.shatteredpixeldungeon.sprites.BlueBatSprite;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ColdGuardSprite;
import com.shatteredpixel.shatteredpixeldungeon.sprites.DiedMonkLoaderSprite;
import com.shatteredpixel.shatteredpixeldungeon.sprites.FlameBoiSprite;
import com.shatteredpixel.shatteredpixeldungeon.sprites.GhostSprite;
import com.shatteredpixel.shatteredpixeldungeon.sprites.IceCryStalSprite;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSprite;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;
import com.shatteredpixel.shatteredpixeldungeon.sprites.KagenoNusujinSprite;
import com.shatteredpixel.shatteredpixeldungeon.sprites.MimicSprite;
import com.shatteredpixel.shatteredpixeldungeon.sprites.SRPDHBLRTT;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ShopkKingSprite;
import com.shatteredpixel.shatteredpixeldungeon.sprites.WFSprite;
import com.shatteredpixel.shatteredpixeldungeon.ui.Icons;
import com.shatteredpixel.shatteredpixeldungeon.ui.Window;
import com.shatteredpixel.shatteredpixeldungeon.ui.changelist.ChangeButton;
import com.shatteredpixel.shatteredpixeldungeon.ui.changelist.ChangeInfo;
import com.watabou.noosa.Image;

import java.util.ArrayList;

public class vM0_6_7_X_Changes {

    public static void addAllChanges(ArrayList<ChangeInfo> changeInfos) {
        add_v0_6_11_Changes(changeInfos);
        add_v0_6_10_Changes(changeInfos);
        add_v0_6_9_Changes(changeInfos);
        add_v0_6_8_Changes(changeInfos);
        add_v0_6_7_Changes(changeInfos);
        add_v0_6_6_Changes(changeInfos);
        add_v0_6_5_Changes(changeInfos);
        add_v0_6_4_Changes(changeInfos);
        add_v0_6_3_Changes(changeInfos);
        add_v0_6_2_Changes(changeInfos);
        add_v0_6_1_Changes(changeInfos);
        add_v0_6_0_Changes(changeInfos);
    }

    public static void add_v0_6_11_Changes( ArrayList<ChangeInfo> changeInfos ) {
        ChangeInfo changes = new ChangeInfo("v0.6.0.0-Beta21-p1.4-5", true, "");
        changes.hardlight(Window.TITLE_COLOR);
        changeInfos.add(changes);

        changes = new ChangeInfo("新内容", false, null);
        changes.hardlight(Window.TITLE_COLOR);
        changeInfos.add(changes);

        changes.addButton(new ChangeButton(new IceCryStalSprite(), ("浊焰魔女AI调整"),
                ("重新调整了浊焰魔女的AI属性")));

        changes.addButton(new ChangeButton(new BlueBatSprite(), ("血影蝙蝠调整"),
                ("英雄15级后法术伤害面板调整")));

        changes = new ChangeInfo("改动", false, null);
        changes.hardlight(Window.CYELLOW);
        changeInfos.add(changes);

        changes.addButton(new ChangeButton(new Image("sprites/spinner.png", 144, 0, 16, 16), (Messages.get(ChangesScene.class, "bugfixes")),
                Messages.get(vM0_6_7_X_Changes.class, "bug_06X31")));

    }

    public static void add_v0_6_10_Changes( ArrayList<ChangeInfo> changeInfos ) {
        ChangeInfo changes = new ChangeInfo("v0.6.0.0-Beta21-p1.2", true, "");
        changes.hardlight(Window.TITLE_COLOR);
        changeInfos.add(changes);

        changes = new ChangeInfo("新内容", false, null);
        changes.hardlight(Window.GREEN_COLOR);
        changeInfos.add(changes);

        changes.addButton(new ChangeButton(new ItemSprite(ItemSpriteSheet.ENDDIED), ("彩蛋武器：终焉"),
                ("正式实装，击败火元素概率掉落")));

        changes = new ChangeInfo("改动", false, null);
        changes.hardlight(Window.CYELLOW);
        changeInfos.add(changes);

        changes.addButton(new ChangeButton(new Image("sprites/spinner.png", 144, 0, 16, 16), (Messages.get(ChangesScene.class, "bugfixes")),
                Messages.get(vM0_6_7_X_Changes.class, "bug_06X30")));

    }

    public static void add_v0_6_9_Changes( ArrayList<ChangeInfo> changeInfos ) {
        ChangeInfo changes = new ChangeInfo("v0.6.0.0-Beta21-p1", true, "");
        changes.hardlight(Window.TITLE_COLOR);
        changeInfos.add(changes);

        changes = new ChangeInfo("新内容", false, null);
        changes.hardlight(Window.GREEN_COLOR);
        changeInfos.add(changes);

        changes.addButton(new ChangeButton(new ItemSprite(ItemSpriteSheet.ENDDIED), ("彩蛋武器：终焉"),
                ("在命运的尽头，亦或者是命运的起点")));

        changes.addButton(new ChangeButton(new ItemSprite(ItemSpriteSheet.GAUNTLETS), ("碧灰双刃"),
                ("武器降级到3阶")));

        changes.addButton(new ChangeButton(new ItemSprite(ItemSpriteSheet.DG3), ("钥匙剑"),
                ("武器提格到5阶，进行了一定的重做")));

        changes = new ChangeInfo("改动", false, null);
        changes.hardlight(Window.CYELLOW);
        changeInfos.add(changes);

        changes.addButton(new ChangeButton(new MimicSprite.Dimand(), ("钻石宝箱王"),
                ("在梦魇Boss中出现新的技能")));

        changes.addButton(new ChangeButton(new GhostSprite(), ("幽灵奖励改变"),
                ("幽灵现在更能出现+3，以及+4，+5品种的武器或护甲")));

        changes.addButton(new ChangeButton(Icons.get(Icons.CHANGES), ("药水癔症"),
                ("暂时为以前的样子，后续会改善")));

        changes.addButton(new ChangeButton(Icons.get(Icons.INFO), ("杂项改动"),
                ("1.部分物品的显示逻辑更新\n2.用户ID系统\n3.调整红龙之王的奖励\n4.修复了一系列的Bug")));


    }

    public static void add_v0_6_8_Changes( ArrayList<ChangeInfo> changeInfos ) {
        ChangeInfo changes = new ChangeInfo("v0.6.0.0-Beta20.80", true, "");
        changes.hardlight(Window.TITLE_COLOR);
        changeInfos.add(changes);

        changes = new ChangeInfo("新内容", false, null);
        changes.hardlight(Window.GREEN_COLOR);
        changeInfos.add(changes);

        changes.addButton(new ChangeButton(new ColdGuardSprite(), ("全新区域：雪凛峡谷"),
                ("雪凛峡谷正式版")));

        changes.addButton(new ChangeButton(new ShopkKingSprite(), ("商人领主商店终端"),
                ("交易使人快乐")));

    }

    public static void add_v0_6_7_Changes( ArrayList<ChangeInfo> changeInfos ) {
        ChangeInfo changes = new ChangeInfo("v0.6.0.0-Beta20.785", true, "");
        changes.hardlight(Window.TITLE_COLOR);
        changeInfos.add(changes);

        changes = new ChangeInfo("新内容", false, null);
        changes.hardlight(Window.GREEN_COLOR);
        changeInfos.add(changes);

        changes.addButton(new ChangeButton(new ColdGuardSprite(), ("全新区域：雪凛峡谷"),
                ("在雪凛峡谷中寻找300年前的支离破碎的线索……\n\n全新商店抢劫系统：V6.0")));

        changes.addButton(new ChangeButton(new ItemSprite(ItemSpriteSheet.DG1), ("月饼"),
                ("限时食物：9-10到10.1，中秋节特供")));

        changes = new ChangeInfo("改动", false, null);
        changes.hardlight(Window.GREEN_COLOR);
        changeInfos.add(changes);

        changes.addButton(new ChangeButton(Icons.get(Icons.INFO), ("杂项改动"),
                ("-NPC对话文本改变\n-部分BGM升级更新")));

        changes.addButton(new ChangeButton(new Image("sprites/spinner.png", 144, 0, 16, 16), (Messages.get(ChangesScene.class, "bugfixes")),
                Messages.get(vM0_6_7_X_Changes.class, "bug_06X28")));
    }

    public static void add_v0_6_6_Changes( ArrayList<ChangeInfo> changeInfos ) {
        ChangeInfo changes = new ChangeInfo("v0.6.0.0-Beta20.75", true, "");
        changes.hardlight(Window.TITLE_COLOR);
        changeInfos.add(changes);

        changes = new ChangeInfo("改动", false, null);
        changes.hardlight(Window.SKYBULE_COLOR);
        changeInfos.add(changes);

        changes.addButton(new ChangeButton(new DiedMonkLoaderSprite(), ("矮人大师优化"),
                ("-1.矮人大师追加神秘之井\n-2.矮人大师血量追加到800")));

        changes.addButton(new ChangeButton(new Image("sprites/spinner.png", 144, 0, 16, 16), (Messages.get(ChangesScene.class, "bugfixes")),
                Messages.get(vM0_6_7_X_Changes.class, "bug_06X26")));

        changes = new ChangeInfo("调整", false, null);
        changes.hardlight(Window.CYELLOW);
        changeInfos.add(changes);

        changes.addButton(new ChangeButton(Icons.get(Icons.INFO), ("滚动文本调整"),
                ("-追加更多的过度文本")));

    }

    public static void add_v0_6_5_Changes( ArrayList<ChangeInfo> changeInfos ) {
        ChangeInfo changes = new ChangeInfo("v0.6.0.0-Beta20.(1-6)", true, "");
        changes.hardlight(Window.TITLE_COLOR);
        changeInfos.add(changes);

        changes = new ChangeInfo("新内容", false, null);
        changes.hardlight(Window.GREEN_COLOR);
        changeInfos.add(changes);

        changes.addButton(new ChangeButton(Icons.get(Icons.INFO), ("其他说明"),
                ("1.圣境密林层贴图更新\n2.监狱BGM正式实装")));

        changes.addButton(new ChangeButton(Icons.get(Icons.RENAME_ON), ("重命名系统"),
                ("为你中意的英雄进行自定义重命名吧,击败第一大层的任意Boss解锁\n" +
                        "为你中意的装备进行自定义重命名吧，解锁条件同上所述。")));

        changes = new ChangeInfo("改动", false, null);
        changes.hardlight(Window.SKYBULE_COLOR);
        changeInfos.add(changes);

        changes.addButton(new ChangeButton(new SRPDHBLRTT(), ("赏金猎人"),
                ("伤害下调至9-12")));

        changes.addButton(new ChangeButton(new KagenoNusujinSprite(), ("影子盗贼"),
                ("AI逻辑改变")));

        changes.addButton(new ChangeButton(new WFSprite(), ("法师初始改动"),
                ("茉莉伊洛是双属性的魔法少女，拥有强大的魔力，她将会把烈焰法杖和冰雪法杖进行随机化作为初始法杖")));

        changes.addButton(new ChangeButton(new Image("sprites/spinner.png", 144, 0, 16, 16), (Messages.get(ChangesScene.class, "bugfixes")),
                Messages.get(vM0_6_7_X_Changes.class, "bug_06X25")));
    }

    public static void add_v0_6_4_Changes( ArrayList<ChangeInfo> changeInfos ) {
        ChangeInfo changes = new ChangeInfo("v0.6.0.0-Beta19", true, "");
        changes.hardlight(Window.TITLE_COLOR);
        changeInfos.add(changes);

        changes = new ChangeInfo("新内容", false, null);
        changes.hardlight(Window.GREEN_COLOR);
        changeInfos.add(changes);

        changes.addButton(new ChangeButton(Icons.get(Icons.BUFFS), ("Boss血量优化"),
                ("现在Boss不仅会显示血量数值，还会实时显示Boss获得的Buff状态条")));

        changes.addButton(new ChangeButton(Icons.get(Icons.DISPLAY), ("怪物面板属性优化"),
                ("现在怪物面板移除了可获得经验并改为上次伤害，并追加移速。且小数点精确到一位。")));

        changes = new ChangeInfo("改动", false, null);
        changes.hardlight(Window.SKYBULE_COLOR);
        changeInfos.add(changes);

        changes.addButton(new ChangeButton(new Image("sprites/spinner.png", 144, 0, 16, 16), (Messages.get(ChangesScene.class, "bugfixes")),
                Messages.get(vM0_6_7_X_Changes.class, "bug_06X24")));

        changes = new ChangeInfo("调整", false, null);
        changes.hardlight(Window.CYELLOW);
        changeInfos.add(changes);

        changes.addButton(new ChangeButton(new BlueBatSprite(), ("小血影改动"),
                ("-小血影在主人15级后将会开启远程攻击\n\n" +
                        "-伤害削弱20%，但血量提升20%")));

    }

    public static void add_v0_6_3_Changes( ArrayList<ChangeInfo> changeInfos ) {
        ChangeInfo changes = new ChangeInfo("v0.6.0.0-BetaXVIII", true, "");
        changes.hardlight(Window.TITLE_COLOR);
        changeInfos.add(changes);

        changes = new ChangeInfo("新内容", false, null);
        changes.hardlight(Window.GREEN_COLOR);
        changeInfos.add(changes);

        changes.addButton(new ChangeButton(Icons.get(Icons.CHALLENGE_ON), ("新挑战:污泥浊水"),
                ("1-4层 给予1回合残废\n" +
                        "6-9层 给予1回合失明\n" +
                        "11-14层 给予2回合冻伤\n" +
                        "16-19层 给予 上面的全部效果附加幻惑3回合\n" +
                        "\n" +
                        "应对策略：\n" +
                        "1.玩家开局获得x4水灵药剂，可获得40回合免疫\n" +
                        "2.制作生石灰来将水蒸发，制作水灵药剂来免疫效果。\n\n" +
                        "挑战开启期间4,8,13,18层将会追加一个食人鱼池子,并且食人鱼属性大幅度下降。")));

        changes = new ChangeInfo("改动", false, null);
        changes.hardlight(Window.SKYBULE_COLOR);
        changeInfos.add(changes);

        changes.addButton(new ChangeButton(new Image("sprites/spinner.png", 144, 0, 16, 16), (Messages.get(ChangesScene.class, "bugfixes")),
                Messages.get(vM0_6_7_X_Changes.class, "bug_06X23")));
    }

    public static void add_v0_6_2_Changes( ArrayList<ChangeInfo> changeInfos ) {
        ChangeInfo changes = new ChangeInfo("v0.6.0.0-BetaXVII", true, "");
        changes.hardlight(Window.TITLE_COLOR);
        changeInfos.add(changes);

        changes = new ChangeInfo("改动", false, null);
        changes.hardlight(Window.SKYBULE_COLOR);
        changeInfos.add(changes);

        changes.addButton(new ChangeButton(new Image("sprites/spinner.png", 144, 0, 16, 16), (Messages.get(ChangesScene.class, "bugfixes")),
                Messages.get(vM0_6_7_X_Changes.class, "bug_06X22")));

        changes = new ChangeInfo("调整", false, null);
        changes.hardlight(Window.CYELLOW);
        changeInfos.add(changes);

        changes.addButton(new ChangeButton(new BlueBatSprite(), ("小血影初始改动"),
                ("小血影10级后将会开启远程攻击")));
    }

    public static void add_v0_6_1_Changes( ArrayList<ChangeInfo> changeInfos ) {
        ChangeInfo changes = new ChangeInfo("v0.6.0.0-BetaXV", true, "");
        changes.hardlight(Window.TITLE_COLOR);
        changeInfos.add(changes);

        changes = new ChangeInfo("新内容", false, null);
        changes.hardlight(Window.GREEN_COLOR);
        changeInfos.add(changes);

        changes.addButton(new ChangeButton(new BlueBatSprite(), ("血影蝙蝠"),
                ("极影铃虹的宠物，为主人而战")));

        changes = new ChangeInfo("改动", false, null);
        changes.hardlight(Window.SKYBULE_COLOR);
        changeInfos.add(changes);

        changes.addButton(new ChangeButton(new Image("sprites/spinner.png", 144, 0, 16, 16), (Messages.get(ChangesScene.class, "bugfixes")),
                Messages.get(vM0_6_7_X_Changes.class, "bug_06X21")));

        changes = new ChangeInfo("调整", false, null);
        changes.hardlight(Window.CYELLOW);
        changeInfos.add(changes);

        changes.addButton(new ChangeButton(new ItemSprite(ItemSpriteSheet.SPIRIT_ARROW), ("女猎初始改动"),
                ("灵能短弓伤害面板从1-6提升到4-9,成长系数不变")));

        changes.addButton(new ChangeButton(new ItemSprite(ItemSpriteSheet.WAND_FROST), ("法师初始改动"),
                ("茉莉伊洛是双属性的魔法少女，拥有强大的魔力，她将会把烈焰法杖和冰雪法杖幻化到快捷栏里，但是这两个法杖受地牢魔力影响，不能升级，不能灌注，但是开局固定3级。\n\n" +
                        "且一旦替换幻化的快捷栏或者退出游戏重新进入将消失。\n" +
                        "\n" +
                        "低语：错误的选择将让你万劫不复的，茉莉！")));

        changes.addButton(new ChangeButton(new ItemSprite(ItemSpriteSheet.SUMMON_ELE), ("战士初始改动"),
                ("蕾零安洁虽然本身没有魔力，但家族世世代代都在研究一种高超的技术，这项技术足以让她在地牢里面有冒险的资本。\n\n使用战士将追加2个唤魔晶柱")));

        changes.addButton(new ChangeButton(new BlueBatSprite(), ("盗贼初始改动"),
                ("极影铃虹的潜能非常强大，她的小蝙蝠经常与她为伴。\n\n盗贼将在开局追加一个小蝙蝠。")));

    }

    public static void add_v0_6_0_Changes( ArrayList<ChangeInfo> changeInfos ) {
        ChangeInfo changes = new ChangeInfo("v0.6.0.0-BetaX", true, "");
        changes.hardlight(Window.TITLE_COLOR);
        changeInfos.add(changes);

        changes = new ChangeInfo("新内容", false, null);
        changes.hardlight(Window.GREEN_COLOR);
        changeInfos.add(changes);

        changes.addButton(new ChangeButton((new Image("Ling.png", 0, 0, 16, 16)), ("开发者的话"),
                ("你好，这里是绫。如你所见，这是全新的魔绫像素地牢，她已经步入了破碎1.2" +
                        ".3的版本。\n\n至此，魔绫像素地牢以后将针对于此破碎底层进行更新。今后不会继续同步底层破碎版本。\n\n" +
                        "同时，本次更新后，后续应该还有几个补丁版。很高兴一路以来有那么多的朋友，非常谢谢你们的支持。\n\n现在，旅途才刚刚开始，魔绫下半段，将会更加精彩。\n" +
                        "在这之前，就让我们继续在上半段的魔绫里面探索前进吧。")));

        changes.addButton(new ChangeButton(Icons.get(Icons.CHALLENGE_ON), ("新挑战:空洞旅程"),
                ("开启本挑战将会在开局获得240点理智，在_没有光芒下_和_部分怪物的近战_将会使你理智降低。详情查看下表:\n" +
                        "-棕色老鼠:20%概率(-1理智/每回合)\n-黑色怨灵:10%概率(-3理智/每回合)\n-火把猎人:40%概率(-1理智/每回合)\n-矮人术士:15%概率" +
                        "(-5理智/每回合)\n-寒冰老鼠:25%概率(-2理智/每回合)\n-DM200:10%概率(-7理智/每回合)\n-矮人武僧:30%的概率(-3理智/每回合)" +
                        "\n-没有光芒Buff的情况下:-1/每回合\n\n_理智回复策略_:\n-_1_:存在光芒的情况下以:[(+1理智+楼层深度/10)/每回合]" +
                        "(举例:20层没有光芒的情况下,1+20/10=3(+3智/每回合)\n-_2_.商人售卖信仰药水，喝下去追加40回合理智\n-_3_.击败敌人可以获得敌人的灵魂," +
                        "灵魂到一定数量可以使提灯可以再次点亮道路。灵魂也可以缓慢回复理智。(50灵魂=1理智回复)\n\n尚未制作完成，敬请期待")));

        changes = new ChangeInfo("改动", false, null);
        changes.hardlight(Window.SKYBULE_COLOR);
        changeInfos.add(changes);

        changes.addButton(new ChangeButton(new Image("sprites/spinner.png", 144, 0, 16, 16), (Messages.get(ChangesScene.class, "bugfixes")),
                Messages.get(vM0_6_7_X_Changes.class, "bug_06X20")));

        changes.addButton(new ChangeButton(new ItemSprite(ItemSpriteSheet.DG24), ("极度秘卷"),
                ("原炎魔秘卷，现在重做。具体请游戏里面自行探索。")));

        changes.addButton(new ChangeButton(Icons.get(Icons.INFO), ("快捷栏调整"),
                ("快捷栏使用说明:\n-1.请最好根据自己的分辨率进行调整，避免出现快捷栏叠加情况\n-2.由于技术问题，快捷栏仅在游戏中才可以设置\n-3.最多支持12个快捷栏，玩得高兴！！！")));

        changes.addButton(new ChangeButton(Icons.get(Icons.CHANGES), ("重大更新"),
                ("魔绫现已更新底层到破碎V1.2.3版本!")));

        changes.addButton(new ChangeButton(Icons.get(Icons.CHALLENGE_ON), ("新挑战和部分挑战改动"),
                ("部分挑战进行重新调整，同时追加全新挑战，欢迎前来探索\n\n注意：部分挑战尚未完成，请等待后续版本")));

        changes.addButton(new ChangeButton(Icons.get(Icons.LANGS), ("本地化模块升级"),
                ("魔绫已经对本地化语言模块优化，使部分低配设备性能更好")));

        changes.addButton(new ChangeButton(Icons.get(Icons.DISPLAY), ("UI优化改动"),
                ("魔绫已经对UI优化改动进行大规模调整，欢迎前来体验")));

        changes = new ChangeInfo("调整", false, null);
        changes.hardlight(Window.CYELLOW);
        changeInfos.add(changes);

        changes.addButton( new ChangeButton(new Image(Assets.Environment.TILES_SEWERS, 48, 80, 16, 16 ), "水晶十字房加强",
                "水晶十字房间改动说明：\n" +
                        "第一个房间：概率在80-270范围给予金币\n" +
                        "第二个房间：概率在符石，种子，卷轴，食物中随机抽取\n" +
                        "第三个房间：概率在1，3，5阶武器，戒指中随机抽取\n" +
                        "第四个房间：概率在护甲，符石，法杖，神器中随机抽取"));

        changes.addButton(new ChangeButton(new ItemSprite(ItemSpriteSheet.FIREFISHSWORD), ("尚方宝剑特效重写"),
                ("优化了尚方宝剑特效，并最大程度上进行了处理")));

        changes = new ChangeInfo("移除", false, null);
        changes.hardlight(Window.RED_COLOR);
        changeInfos.add(changes);

        changes.addButton(new ChangeButton(new FlameBoiSprite(), ("火焰机器人"),
                ("移除火焰机器人在常规局的出现，仅出现在支离破碎的精英怪概率里面")));

        changes.addButton(new ChangeButton(new ItemSprite(ItemSpriteSheet.BlackDog), ("黑狗爪"),
                ("移除黑狗爪，它已不再有当年的威风")));

    }
}
