import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class DataSpec extends Specification{

    @Shared
    List<String> neededEverywhere = Mock()

    @Unroll
    def "Math.max of #a and #b is #c"(){
        expect:
        Math.max(a, b) == c

        where:
        a | b || c
        1 | 3 || 3
        8 | 7 || 8
        0 | 0 || 0
    }

    @Unroll
    def "Math.max of #a and #b is #c test"(){
        expect:
        Math.max(a, b) == c

        where:
        a << [1, 8, 0]
        b << [3, 7, 0]
        c << [3, 8, 0]
    }

}
