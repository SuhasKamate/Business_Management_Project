package tests

import pages.GooglePage

class GoogleSpec extends BaseSpec {

	def "Search \"hello!\""() {

		when:
			to GooglePage

		then:
			at GooglePage
	}

}
