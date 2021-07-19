package xyz.namekun.akitastatistics;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class AkitaStatisticsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("akita")) {
            if (args.length == 0) {
                sender.sendMessage("§a/akita help§7でヘルプを表示");
            } else {
                if (args[0].equals("help")) {
                    sender.sendMessage("§a/akita help§7: ヘルプを表示\n§a/akita info [city]§7: 指定した市の統計情報を表示(未指定の場合は秋田県の統計情報)\n§a/akita weather [city]§7: 指定した市の天気を表示(未指定の場合は秋田市の天気)");
                } else if (args[0].equals("info")) {
                    if (args.length <= 1) {
                        //info of akita pref
                        String url = "https://ja.wikipedia.org/wiki/%E7%A7%8B%E7%94%B0%E7%9C%8C";
                        try {
                            akita(sender, args[0], null, url);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        String url;
                        if (args[1].equals("秋田市")) {
                            url = "https://ja.wikipedia.org/wiki/%E7%A7%8B%E7%94%B0%E5%B8%82";
                        } else if (args[1].equals("男鹿市")) {
                            url = "https://ja.wikipedia.org/wiki/%E7%94%B7%E9%B9%BF%E5%B8%82";
                        } else if (args[1].equals("潟上市")) {
                            url = "https://ja.wikipedia.org/wiki/%E6%BD%9F%E4%B8%8A%E5%B8%82";
                        } else if (args[1].equals("五城目町")) {
                            url = "https://ja.wikipedia.org/wiki/%E4%BA%94%E5%9F%8E%E7%9B%AE%E7%94%BA";
                        } else if (args[1].equals("八郎潟町")) {
                            url = "https://ja.wikipedia.org/wiki/%E5%85%AB%E9%83%8E%E6%BD%9F%E7%94%BA";
                        } else if (args[1].equals("井川町")) {
                            url = "https://ja.wikipedia.org/wiki/%E4%BA%95%E5%B7%9D%E7%94%BA";
                        } else if (args[1].equals("大潟村")) {
                            url = "https://ja.wikipedia.org/wiki/%E5%A4%A7%E6%BD%9F%E6%9D%91";
                        } else if (args[1].equals("大仙市")) {
                            url = "https://ja.wikipedia.org/wiki/%E5%A4%A7%E4%BB%99%E5%B8%82";
                        } else if (args[1].equals("仙北市")) {
                            url = "https://ja.wikipedia.org/wiki/%E4%BB%99%E5%8C%97%E5%B8%82";
                        } else if (args[1].equals("美郷町")) {
                            url = "https://ja.wikipedia.org/wiki/%E7%BE%8E%E9%83%B7%E7%94%BA_(%E7%A7%8B%E7%94%B0%E7%9C%8C)";
                        } else if (args[1].equals("大館市")) {
                            url = "https://ja.wikipedia.org/wiki/%E5%A4%A7%E9%A4%A8%E5%B8%82";
                        } else if (args[1].equals("北秋田市")) {
                            url = "https://ja.wikipedia.org/wiki/%E5%8C%97%E7%A7%8B%E7%94%B0%E5%B8%82";
                        } else if (args[1].equals("上小阿仁村")) {
                            url = "https://ja.wikipedia.org/wiki/%E4%B8%8A%E5%B0%8F%E9%98%BF%E4%BB%81%E6%9D%91";
                        } else if (args[1].equals("由利本荘市")) {
                            url = "https://ja.wikipedia.org/wiki/%E7%94%B1%E5%88%A9%E6%9C%AC%E8%8D%98%E5%B8%82";
                        } else if (args[1].equals("にかほ市")) {
                            url = "https://ja.wikipedia.org/wiki/%E3%81%AB%E3%81%8B%E3%81%BB%E5%B8%82";
                        } else if (args[1].equals("横手市")) {
                            url = "https://ja.wikipedia.org/wiki/%E6%A8%AA%E6%89%8B%E5%B8%82";
                        } else if (args[1].equals("能代市")) {
                            url = "https://ja.wikipedia.org/wiki/%E8%83%BD%E4%BB%A3%E5%B8%82";
                        } else if (args[1].equals("藤里町")) {
                            url = "https://ja.wikipedia.org/wiki/%E8%97%A4%E9%87%8C%E7%94%BA";
                        } else if (args[1].equals("三種町")) {
                            url = "https://ja.wikipedia.org/wiki/%E4%B8%89%E7%A8%AE%E7%94%BA";
                        } else if (args[1].equals("八峰町")) {
                            url = "https://ja.wikipedia.org/wiki/%E5%85%AB%E5%B3%B0%E7%94%BA";
                        } else if (args[1].equals("湯沢市")) {
                            url = "https://ja.wikipedia.org/wiki/%E6%B9%AF%E6%B2%A2%E5%B8%82";
                        } else if (args[1].equals("羽後町")) {
                            url = "https://ja.wikipedia.org/wiki/%E7%BE%BD%E5%BE%8C%E7%94%BA";
                        } else if (args[1].equals("東成瀬村")) {
                            url = "https://ja.wikipedia.org/wiki/%E6%9D%B1%E6%88%90%E7%80%AC%E6%9D%91";
                        } else if (args[1].equals("鹿角市")) {
                            url = "https://ja.wikipedia.org/wiki/%E9%B9%BF%E8%A7%92%E5%B8%82";
                        } else if (args[1].equals("小坂町")) {
                            url = "https://ja.wikipedia.org/wiki/%E5%B0%8F%E5%9D%82%E7%94%BA";
                        } else {
                            sender.sendMessage("§c正しい市町村名を指定してください。");
                            return true;
                        }
                        try {
                            akita(sender, args[0], args[1], url);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } else if (args[0].equals("weather")) {
                    if (args.length <= 1) {
                        //weather of akita city
                        String url = "https://tenki.jp/forecast/2/8/3210/5201/";
                        try {
                            akita(sender, args[0], null, url);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        String url;
                        if (args[1].equals("秋田市")) {
                            url = "https://tenki.jp/forecast/2/8/3210/5201/";
                        } else if (args[1].equals("男鹿市")) {
                            url = "https://tenki.jp/forecast/2/8/3210/5206/";
                        } else if (args[1].equals("潟上市")) {
                            url = "https://tenki.jp/forecast/2/8/3210/5211/";
                        } else if (args[1].equals("五城目町")) {
                            url = "https://tenki.jp/forecast/2/8/3210/5361/";
                        } else if (args[1].equals("八郎潟町")) {
                            url = "https://tenki.jp/forecast/2/8/3210/5363/";
                        } else if (args[1].equals("井川町")) {
                            url = "https://tenki.jp/forecast/2/8/3210/5366/";
                        } else if (args[1].equals("大潟村")) {
                            url = "https://tenki.jp/forecast/2/8/3210/5368/";
                        } else if (args[1].equals("大仙市")) {
                            url = "https://tenki.jp/forecast/2/8/3220/5212/";
                        } else if (args[1].equals("仙北市")) {
                            url = "https://tenki.jp/forecast/2/8/3220/5215/";
                        } else if (args[1].equals("美郷町")) {
                            url = "https://tenki.jp/forecast/2/8/3220/5434/";
                        } else if (args[1].equals("大館市")) {
                            url = "https://tenki.jp/forecast/2/8/3220/5204/";
                        } else if (args[1].equals("北秋田市")) {
                            url = "https://tenki.jp/forecast/2/8/3220/5213/";
                        } else if (args[1].equals("上小阿仁村")) {
                            url = "https://tenki.jp/forecast/2/8/3220/5327/";
                        } else if (args[1].equals("由利本荘市")) {
                            url = "https://tenki.jp/forecast/2/8/3210/5210/";
                        } else if (args[1].equals("にかほ市")) {
                            url = "https://tenki.jp/forecast/2/8/3210/5214/";
                        } else if (args[1].equals("横手市")) {
                            url = "https://tenki.jp/forecast/2/8/3220/5203/";
                        } else if (args[1].equals("能代市")) {
                            url = "https://tenki.jp/forecast/2/8/3210/5202/";
                        } else if (args[1].equals("藤里町")) {
                            url = "https://tenki.jp/forecast/2/8/3210/5346/";
                        } else if (args[1].equals("三種町")) {
                            url = "https://tenki.jp/forecast/2/8/3210/5348/";
                        } else if (args[1].equals("八峰町")) {
                            url = "https://tenki.jp/forecast/2/8/3210/5349/";
                        } else if (args[1].equals("湯沢市")) {
                            url = "https://tenki.jp/forecast/2/8/3220/5207/";
                        } else if (args[1].equals("羽後町")) {
                            url = "https://tenki.jp/forecast/2/8/3220/5463/";
                        } else if (args[1].equals("東成瀬村")) {
                            url = "https://tenki.jp/forecast/2/8/3220/5464/";
                        } else if (args[1].equals("鹿角市")) {
                            url = "https://tenki.jp/forecast/2/8/3220/5209/";
                        } else if (args[1].equals("小坂町")) {
                            url = "https://tenki.jp/forecast/2/8/3220/5303/";
                        } else {
                            sender.sendMessage("§c正しい市町村名を指定してください。");
                            return true;
                        }
                        try {
                            akita(sender, args[0], args[1], url);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    sender.sendMessage("§a/akita help§7でヘルプを表示");
                }
            }
        }
        return true;
    }

    public void akita(CommandSender sender, String arg0, String arg1, String url) throws IOException {
        if (arg0.equalsIgnoreCase("info")) {
            if (arg1 == null) {
                Document document = Jsoup.connect(url).get();
                Elements elements = document.select("table.infobox.bordered tbody tr td b");
                String[] string = new String[3];
                int i = 0;
                for (Element element : elements) {
                    string[i] = element.text();
                    i++;
                }
                sender.sendMessage("--------------\n§6秋田県の統計情報" + "\n§e面積: " + string[0] + "\n§b人口: " + string[1] + "\n§c人口密度: " + string[2] + "\n§r--------------");
                return;
            } else {
                Document document = Jsoup.connect(url).get();
                Elements elements = document.select("table.infobox.bordered tbody tr td b");
                String[] string = new String[10]; //例外吐かれても困るから実用上十分どころじゃない程の配列のサイズをご用意
                int i = 0;
                for (Element element : elements) {
                    string[i] = element.text();
                    i++;
                }
                sender.sendMessage("--------------\n§6" + arg1 + "§6の統計情報" + "\n§e面積: " + string[0] + "\n§b人口: " + string[1] + "\n§c人口密度: " + string[2] + "\n§r--------------");
            }
        }
        if (arg0.equalsIgnoreCase("weather")) {
            if (arg1 == null) {
                Document document = Jsoup.connect(url).get();
                sender.sendMessage("§7--------------------");
                sender.sendMessage("秋田市");
                sender.sendMessage("§7--------------------");
                Elements elements = document.select(".today-weather .left-style");
                sender.sendMessage(elements.text());
                elements = document.select(".today-weather .weather-icon .weather-telop");
                sender.sendMessage("§e天気: §r" + elements.text());
                elements = document.select(".today-weather .high-temp.temp, .today-weather .high-temp.tempdiff");
                sender.sendMessage("§c最高気温: §r" + elements.text());
                elements = document.select(".today-weather .low-temp.temp, .today-weather .low-temp.tempdiff");
                sender.sendMessage("§b最低気温: §r" + elements.text());
                sender.sendMessage("§7--------------------");
                elements = document.select(".tomorrow-weather .left-style");
                sender.sendMessage(elements.text());
                elements = document.select(".tomorrow-weather .weather-icon .weather-telop");
                sender.sendMessage("§e天気: §r" + elements.text());
                elements = document.select(".tomorrow-weather .high-temp.temp, .tomorrow-weather .high-temp.tempdiff");
                sender.sendMessage("§c最高気温: §r" + elements.text());
                elements = document.select(".tomorrow-weather .low-temp.temp, .tomorrow-weather .low-temp.tempdiff");
                sender.sendMessage("§b最低気温: §r" + elements.text());
                sender.sendMessage("§7--------------------");
            } else {
                Document document = Jsoup.connect(url).get();
                sender.sendMessage("§7--------------------");
                sender.sendMessage(arg1);
                sender.sendMessage("§7--------------------");
                Elements elements = document.select(".today-weather .left-style");
                sender.sendMessage(elements.text());
                elements = document.select(".today-weather .weather-icon .weather-telop");
                sender.sendMessage("§e天気: §r" + elements.text());
                elements = document.select(".today-weather .high-temp.temp, .today-weather .high-temp.tempdiff");
                sender.sendMessage("§c最高気温: §r" + elements.text());
                elements = document.select(".today-weather .low-temp.temp, .today-weather .low-temp.tempdiff");
                sender.sendMessage("§b最低気温: §r" + elements.text());
                sender.sendMessage("§7--------------------");
                elements = document.select(".tomorrow-weather .left-style");
                sender.sendMessage(elements.text());
                elements = document.select(".tomorrow-weather .weather-icon .weather-telop");
                sender.sendMessage("§e天気: §r" + elements.text());
                elements = document.select(".tomorrow-weather .high-temp.temp, .tomorrow-weather .high-temp.tempdiff");
                sender.sendMessage("§c最高気温: §r" + elements.text());
                elements = document.select(".tomorrow-weather .low-temp.temp, .tomorrow-weather .low-temp.tempdiff");
                sender.sendMessage("§b最低気温: §r" + elements.text());
                sender.sendMessage("§7--------------------");
            }
        }
    }
}
