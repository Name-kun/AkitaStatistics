package xyz.namekun.akitastatistics;

import org.bukkit.plugin.java.JavaPlugin;

public final class AkitaStatistics extends JavaPlugin {

    /*
    今からこのウンコードを解読し、私に数多のｳﾝｺを投げんとしているそこの君。
    大事な話があるから、一度立ち止まって聞いて欲しい。
    つい先日私は気の迷いだったのか、ワンタンスープに目を遣り、気付けば湯を注いでいた。
    それもﾌﾟﾘｯﾌﾟﾘのワンタンらしい。一同の期待がワンタンに会する中、私は出来たてのﾎｯｶﾎｶなワンタンを口へ放り投げた。
    何ということだろう...........

    水　餃　子　じ　ゃ　ね　え　か　（　迫　真　）

    驚きました、ええ。まさかワンタンスープだと思って食べていたものが水餃子だったとは ※ワンタンです
    ワンタンもﾌﾟﾘｯﾌﾟﾘの飽和点へ差し掛かると最早「それ」はあるべき姿ではなく水餃子と化すのだ。
    という事で、何方かワンタンスープに水餃子を投下してくれる方を募集します、味の感想は随時募集中です。

    本日は過飽和ﾌﾟﾘｯﾌﾟﾘﾜﾝﾁｬﾝ、ｱｯﾔﾍﾞｯ、ｺﾞﾎﾝｺﾞﾎﾝ、過飽和ﾌﾟﾘｯﾌﾟﾘワンタンのお話でした。
    皆さんのﾌﾟﾘｯﾌﾟﾘなContributionもお待ちしております(?)
    それではまた後ほど。
     */

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("akita").setExecutor(new AkitaStatisticsCommand());
        getCommand("akita").setTabCompleter(new AkitaStatisticsTab());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
