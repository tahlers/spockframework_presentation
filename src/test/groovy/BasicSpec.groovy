import spock.lang.IgnoreIf
import spock.lang.Issue
import spock.lang.Narrative
import spock.lang.PendingFeature
import spock.lang.Specification
import spock.lang.Timeout
import spock.lang.Title

import java.util.concurrent.TimeUnit

@Title("This is an easy to read title")
@Narrative("""
As a user
I want to change the world
So that it is a better place.
""")
class BasicSpec extends Specification {

    def setup(){
        println("setup")
    }

    def cleanup(){
        println("cleanup")
    }

    def setupSpec(){
        println("setupSpec")
    }

    def cleanupSpec(){
        println("cleanupSpec")
    }

    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    def "The StringJoiner should join strings with a given argument"(){
        given:
        StringJoiner joiner = new StringJoiner(", ")

        when:
        joiner.add("Hello")
        joiner.add("World!")

        then:
        joiner.toString() == "Hello, World!"

    }

    @Issue("JIRA-342")
    def "the length method on Strings should count characters"(){
        given:
        String testString = "test"

        expect:
        testString.length() == 4
    }

    @IgnoreIf({ os.windows })
    def "to throw or not to throw, that is the question"(){
        when:
        throw new IllegalArgumentException("illegal hamlet quote detected")

        then:
        IllegalArgumentException e = thrown()
        e.message.contains("hamlet")
    }

    @PendingFeature
    def "this is not finished yet"() {
        expect:
        //println("test")
        throw new IllegalAccessException()
    }


}
