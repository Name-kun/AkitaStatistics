package xyz.namekun.akitastatistics;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class AkitaStatisticsTab implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> tab = new ArrayList<>();
        if (command.getName().equalsIgnoreCase("akita")) {
            if (args.length == 1) {
                tab.add("help");
                tab.add("info");
                tab.add("weather");
            } else if (args.length == 2) {
                if (args[0].equals("info") || args[0].equals("weather")) {
                    tab.add("秋田市");
                    tab.add("男鹿市");
                    tab.add("潟上市");
                    tab.add("五城目町");
                    tab.add("八郎潟町");
                    tab.add("井川町");
                    tab.add("大潟村");
                    tab.add("大仙市");
                    tab.add("仙北市");
                    tab.add("美郷町");
                    tab.add("大館市");
                    tab.add("北秋田市");
                    tab.add("上小阿仁村");
                    tab.add("由利本荘市");
                    tab.add("にかほ市");
                    tab.add("横手市");
                    tab.add("能代市");
                    tab.add("藤里町");
                    tab.add("三種町");
                    tab.add("八峰町");
                    tab.add("湯沢市");
                    tab.add("羽後町");
                    tab.add("東成瀬村");
                    tab.add("鹿角市");
                    tab.add("小坂町");
                }
            }
        }
        return tab;
    }
}
