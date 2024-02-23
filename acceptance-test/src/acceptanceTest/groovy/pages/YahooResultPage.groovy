import geb.Page

class YahooResultPage extends Page  {

    public static String searchWord;

    static at = { title.startsWith(searchWord) }
}
