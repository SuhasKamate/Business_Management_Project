import geb.spock.GebSpec

class YahooSpec extends BaseSpec{

	def "Search \"hello!\""() {
		String q = "hello!"
		YahooResultPage.searchWord = q

		when:
			to YahooQueryPage

		and:
			search(q)

		then:
			waitFor {at YahooResultPage}
	}

}
