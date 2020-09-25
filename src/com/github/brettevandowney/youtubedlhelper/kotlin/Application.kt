package com.github.brettevandowney.youtubedlhelper.kotlin

import com.github.brettevandowney.youtubedlhelper.kotlin.web.MainPage
import com.github.brettevandowney.youtubedlhelper.kotlin.web.pages.pages.DownloadTemplatePage
import com.github.brettevandowney.youtubedlhelper.kotlin.web.theme.DefaultTheme
import com.github.brettevandowney.youtubedlhelper.kotlin.web.theme.Theme
import io.ktor.application.*
import io.ktor.client.*
import io.ktor.client.engine.apache.*
import io.ktor.client.features.auth.*
import io.ktor.features.*
import io.ktor.gson.*
import io.ktor.html.*
import io.ktor.http.content.*
import io.ktor.routing.*
import io.ktor.sessions.*
import kotlinx.html.body
import kotlinx.html.h1
import kotlinx.html.li
import kotlinx.html.ul


/**
 * Starts the template. This template uses server-side content
 * rendering by joining various prebuilt modules. The related
 * client side TypeScript and SCSS can be found within the web folder
 * with under similar named template files.
 */
fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    install(Sessions) {
        cookie<DlSession>("MY_SESSION") {
            cookie.extensions["SameSite"] = "lax"
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
        // includes static resources
        static("/static") {
            resources("static")
        }

        // homepage
        get("/") {
            call.respondHtmlTemplate(MainPage()) {}
        }

        // /downloads page
        get("/downloads") {
            val theme = Theme(DefaultTheme().themes)
            call.respondHtmlTemplate(MainPage(theme = theme, page = DownloadTemplatePage(theme))) {}
        }

        // session template
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
    }
}

/**
 * The data class used for a client's
 * session.
 */
data class DlSession(var count: Int = 0)