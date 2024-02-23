package pages

import geb.Page

class GooglePage extends Page  {


    static at = { title.startsWith("Google") }
    static url = "http://www.google.com"

    static content = {
        searchField { $("input", name: "q") }
        searchButton { $("input", name: "btnK") }
    }

    def click(){
         searchButton.click()
    }


}
