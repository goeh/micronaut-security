package io.micronaut.security.oauth2.docs.github

//tag::clazz[]
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming
import io.micronaut.core.annotation.Introspected

@Introspected
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
class GithubUser {

    var login: String? = null
    var name: String? = null
    var email: String? = null
}
//end::clazz[]