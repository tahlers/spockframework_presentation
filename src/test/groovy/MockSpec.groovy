import spock.lang.Specification

class MockSpec extends Specification{

    def "test some mocking capabilities"(){
        given:
        List<String> mockList = Mock()

        when:
        mockList.add("second")
        mockList.add("first")

        then:
        1 * mockList.add("second")

        then:
        1 * mockList.add(_)

    }

    def "test some stubbing capabilities"(){
        when:
        List<String> mockList = Mock()
        mockList.size() >> 4

        then:
        mockList.size() == 4

        when:
        mockList = Mock()
        mockList.size() >>> [2, 3, 4]

        then:
        mockList.size() == 2
        mockList.size() == 3
        mockList.size() == 4

        when:
        mockList.contains("hello") >> true

        then:
        mockList.contains("hello")

        when:
        mockList = Mock()
        mockList.contains(_) >> { args -> args[0].startsWith("h")}

        then:
        mockList.contains("hblah")

        when:
        mockList = Mock()
        2 * mockList.contains(_) >> { args -> args[0].startsWith("h")}

        then:
        mockList.contains("hblah")
        !mockList.contains("test")

    }
}
