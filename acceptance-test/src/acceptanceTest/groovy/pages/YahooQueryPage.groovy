import geb.Page

class YahooQueryPage extends Page {

    static url = "https://www.yahoo.com/"

    static at = { title.contentEquals("Yahoo") }

    static content = {
        searchField { $("input", name: "p")}
        searchButton { $("button", id:"uh-search-button") }
    }

   void search(String word) {
        searchField.value(word)
        searchButton.click()
    }
}
