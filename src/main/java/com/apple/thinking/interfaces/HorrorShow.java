package com.apple.thinking.interfaces;

/**
 * @author cl, lu.chen.@htouhui.com
 * @version 1.0
 */
public class HorrorShow {
    static void u(Monster b) {
        b.menace();
    }

    static void v(DangerousMonster d) {
        d.menace();
        d.destroy();
    }

    static void w(Lethal l) {
        l.kill();
    }

    public static void main(String[] args) {
        DangerousMonster d = new DragonZilla();
        u(d);
        v(d);

        Vampire v = new VeryBadVampire();
        u(v);
        v(v);
        w(v);
    }
}

interface Monster {
    void menace();
}

interface DangerousMonster extends Monster {
    void destroy();
}

interface Lethal {
    void kill();
}

class DragonZilla implements DangerousMonster {

    @Override
    public void menace() {

    }

    @Override
    public void destroy() {

    }
}

/**
 * 该语法仅适用于接口继承。通常来说，extends只能用于单一类，但是在构建接口时可以引用多个基类接口。接口名之间用逗号分隔
 */
interface Vampire extends DangerousMonster, Lethal {
    void drinkBlood();
}

class VeryBadVampire implements Vampire {

    @Override
    public void menace() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void kill() {

    }

    @Override
    public void drinkBlood() {

    }
}
