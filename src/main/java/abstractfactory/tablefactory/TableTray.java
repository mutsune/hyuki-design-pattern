package abstractfactory.tablefactory;

import abstractfactory.factory.Item;
import abstractfactory.factory.Tray;

public class TableTray extends Tray {
    public TableTray(String caption) {
        super(caption);
    }

    @Override
    public String makeHTML() {
        StringBuilder buffer = new StringBuilder();
        buffer.append("<td>");
        buffer.append("<table width=\"100%\" border=\"1\"><tr>");
        buffer.append("<td bgcolor=\"#cccccc\" align=\"center\" colspan=\"").append(tray.size()).append("\"><b>").append(caption).append("</b></td>");
        buffer.append("</tr>\n");
        buffer.append("<tr>\n");
        for (Item item : tray) {
            buffer.append(item.makeHTML());
        }
        buffer.append("</tr></table>");
        buffer.append("</td>");
        return buffer.toString();
    }
}
