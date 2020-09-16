package com.github.brettevandowney.youtubedlhelper.kotlin

import com.github.brettevandowney.youtubedlhelper.kotlin.web.MainTemplate
import io.ktor.application.*
import io.ktor.client.*
import io.ktor.client.engine.apache.*
import io.ktor.client.features.auth.*
import io.ktor.features.*
import io.ktor.gson.*
import io.ktor.html.*
import io.ktor.http.content.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.sessions.*
import kotlinx.html.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    install(Sessions) {
        cookie<DlSession>("MY_SESSION") {
            cookie.extensions["SameSit e"] = "lax"
        }
    }

    install(PartialContent) {
    }

    install(ContentNegotiation) {
        gson {
        }
    }

    val client = HttpClient(Apache) {
        install(Auth) {
        }
    }

    routing {
        // Static feature. Try to access `/static/ktor_logo.svg`
        static("/static") {
            resources("static")
        }

        get("/") {

            call.respondHtmlTemplate(MainTemplate()) {
                columns {
                }
            }
        }

        get("/html-dsl") {
            call.respondHtml {
                head {
                    link(rel = "stylesheet", href = "/static/styles/csscompiled/main.css")
                }
                body {
                    h1 { +"Brett Downey's Website" }
                    ul {
                        for (n in 1..10) {
                            li { +"$n" }
                        }
                    }
                }
            }
        }

        get("/session/increment") {
            val session = call.sessions.get<DlSession>() ?: DlSession()
            session.count++
            call.sessions.set(session)
            call.respondHtml {

                body {
                    h1 { +"HTML" }
                    ul {
                        for (n in 1..session.count) {
                            li { +"$n" }
                        }
                    }
                }
            }
        }

        get("/json/gson") {
            call.respond(mapOf("hello" to "world"))
        }
    }
}

data class IndexData(val items: List<Int>)
data class DlSession(var count: Int = 0)