package abstractfactory;

import abstractfactory.factory.Factory;
import abstractfactory.factory.Link;
import abstractfactory.factory.Page;
import abstractfactory.factory.Tray;

public class Main {
    public static void main(String[] args) {
        outputHTML("abstractfactory.listfactory.ListFactory");
        outputHTML("abstractfactory.tablefactory.TableFactory");
    }

    private static void outputHTML(String className) {
        Factory factory = Factory.getFactory(className);
        Link asahi = factory.createLink("朝日新聞", "https://www.asahi.com/");
        Link yomiuri = factory.createLink("読売新聞", "https://www.yomiuri.com/");
        Link usYahoo = factory.createLink("Yahoo!", "https://www.yahoo.com/");
        Link jpYahoo = factory.createLink("Yahoo! JAPAN", "https://www.yahoo.com/");
        Link excite = factory.createLink("Excite", "https://www.excite.com/");
        Link google = factory.createLink("Google", "https://www.google.com/");

        Tray trayNews = factory.createTray("新聞");
        trayNews.add(asahi);
        trayNews.add(yomiuri);
        Tray trayYahoo = factory.createTray("Yahoo!");
        trayYahoo.add(usYahoo);
        trayYahoo.add(jpYahoo);
        Tray traySearch = factory.createTray("サーチエンジン");
        traySearch.add(trayYahoo);
        traySearch.add(excite);
        traySearch.add(google);

        Page page = factory.createPage(className, "me");
        page.add(trayNews);
        page.add(traySearch);
        page.output();
    }
}
