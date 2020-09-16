package com.github.brettevandowney.youtubedlhelper.kotlin.web


import com.github.brettevandowney.youtubedlhelper.kotlin.web.theme.Theme
import io.ktor.html.*
import kotlinx.html.*
import kotlin.collections.set

class DefaultCenterTemplate(private val theme: Theme) : Template<FlowContent> {
    private val randomVideo = "/static/banner${theme.random}.mp4"
    val item = PlaceholderList<UL, FlowContent>()

    override fun FlowContent.apply() {
        main {
            role = "main"
            div("carousel slide") {
                id = "topCarousel"
                attributes["data-ride"] = "carousel"

                // video background
                video {
                    attributes["autoplay"] = ""
                    attributes["loop"] = ""
                    attributes["muted"] = ""
                    attributes["playsinline"] = ""
                    src = randomVideo
                }

                // carousel indicators
                ol("carousel-indicators") {
                    li("active") {
                        attributes["data-target"] = "#topCarousel"
                        attributes["data-slide-to"] = "0"
                    }
                    for (n in 1..3) {
                        li {
                            attributes["data-target"] = "#topCarousel"
                            attributes["data-slide-to"] = n.toString()
                        }
                    }
                }

                div("carousel-inner") {
                    div("carousel-item active") {
                        div("container") {
                            div("carousel-caption text-left ${theme.className}") {
                                h1 { +"""Built using Kotlin and Java""" }
                                p { +"""Using TypeScript, SCSS, Bootstrap, jQuery, and jQueryUI.""" }
                                p {
                                    a(classes = "btn btn-lg btn-primary") {
                                        href = "#"
                                        role = "button"
                                        +"""View Github Project"""
                                    }
                                }
                            }
                        }
                    }
                    div("carousel-item") {
                        div("container") {
                            div("carousel-caption ${theme.className}") {
                                h1 { +"""Youtube-DL Helper""" }
                                p { +"""Download videos from the internet using youtube-dl, integrated into your browser.""" }
                                p {
                                    a(classes = "btn btn-lg btn-primary") {
                                        href = "#"
                                        role = "button"
                                        +"""Download Now"""
                                    }
                                }
                            }
                        }
                    }
                    div("carousel-item") {
                        div("container") {
                            div("carousel-caption text-right ${theme.className}") {
                                h1 { +"""Get the extension.""" }
                                p { +"""Integrated in Chrome, Firefox, and Opera for the best possible experience.""" }
                                p {
                                    a(classes = "btn btn-lg btn-primary") {
                                        href = "#"
                                        role = "button"
                                        +"""Open extension site"""
                                    }
                                }
                            }
                        }
                    }

                    div("carousel-item") {
                        div("container") {
                            div("carousel-caption text-right ${theme.className}") {
                                h1 { +"""Large support""" }
                                p { +"""Any website which youtube-dl can download from, youtube-dl helper can as well.""" }
                                p {
                                    a(classes = "btn btn-lg btn-primary") {
                                        href = "#"
                                        role = "button"
                                        +"""Open extension site"""
                                    }
                                }
                            }
                        }
                    }
                }
                a(classes = "carousel-control-prev") {
                    href = "#topCarousel"
                    role = "button"
                    attributes["data-slide"] = "prev"
                    span("carousel-control-prev-icon") {
                        attributes["aria-hidden"] = "true"
                    }
                    span("sr-only") { +"""Previous""" }
                }
                a(classes = "carousel-control-next") {
                    href = "#topCarousel"
                    role = "button"
                    attributes["data-slide"] = "next"
                    span("carousel-control-next-icon") {
                        attributes["aria-hidden"] = "true"
                    }
                    span("sr-only") { +"""Next""" }
                }
            }

            div("container marketing") {
                div("row") {
                    div("col-lg-4") {
                        svgMarketing()
                        h2 { +"""Settings""" }
                        p { +"""Donec sed odio dui. Etiam porta sem malesuada magna mollis euismod. Nullam id dolor id nibh ultricies vehicula ut id elit. Morbi leo risus, porta ac consectetur ac, vestibulum at eros. Praesent commodo cursus magna.""" }
                        p {
                            a(classes = "btn btn-secondary") {
                                href = "#"
                                role = "button"
                                +"""View details &raquo;"""
                            }
                        }
                    }
                    div("col-lg-4") {
                        svgMarketing()
                        h2 { +"""Recently Downloads""" }
                        p { +"""Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit. Cras mattis consectetur purus sit amet fermentum. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh.""" }
                        p {
                            a(classes = "btn btn-secondary") {
                                href = "#"
                                role = "button"
                                +"""View details &raquo;"""
                            }
                        }
                    }
                    div("col-lg-4") {
                        svgMarketing()
                        h2 { +"""Favourites""" }
                        p { +"""Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.""" }
                        p {
                            a(classes = "btn btn-secondary") {
                                href = "#"
                                role = "button"
                                +"""View details &raquo;"""
                            }
                        }
                    }
                }


                hr("featurette-divider") {
                }
                div("row featurette") {
                    div("col-md-7") {
                        h2("featurette-heading") {
                            +"""First featurette heading."""
                            span("text-muted") { +"""It’ll blow your mind.""" }
                        }
                        p("lead") { +"""Donec ullamcorper nulla non metus auctor fringilla. Vestibulum id ligula porta felis euismod semper. Praesent commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus, tellus ac cursus commodo.""" }
                    }
                    div("col-md-5") {
                        svgFeaturette()
                    }
                }
                hr("featurette-divider") {
                }
                div("row featurette") {
                    div("col-md-7 order-md-2") {
                        h2("featurette-heading") {
                            +"""Oh yeah, it’s that good."""
                            span("text-muted") { +"""See for yourself.""" }
                        }
                        p("lead") { +"""Donec ullamcorper nulla non metus auctor fringilla. Vestibulum id ligula porta felis euismod semper. Praesent commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus, tellus ac cursus commodo.""" }
                    }
                    div("col-md-5 order-md-1") {
                        svgFeaturette()
                    }
                }
                hr("featurette-divider") {
                }
                div("row featurette") {
                    div("col-md-7") {
                        h2("featurette-heading") {
                            +"""And lastly, this one."""
                            span("text-muted") { +"""Checkmate.""" }
                        }
                        p("lead") { +"""Donec ullamcorper nulla non metus auctor fringilla. Vestibulum id ligula porta felis euismod semper. Praesent commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus, tellus ac cursus commodo.""" }
                    }
                    div("col-md-5") {
                        svgFeaturette()
                    }
                }
                hr("featurette-divider") {
                }
            }

            footer("container") {
                p("float-right") {
                    a {
                        href = "#"
                        +"""Back to top"""
                    }
                }
                p {
                    +"""2017-2020 Company, Inc."""
                    a {
                        href = "#"
                        +"""Privacy"""
                    }
                    a {
                        href = "#"
                        +"""Terms"""
                    }
                }
            }
        }
    }

    private fun DIV.svgMarketing() {
        svg("bd-placeholder-img rounded-circle") {
            attributes["width"] = "140"
            attributes["height"] = "140"
            attributes["preserveaspectratio"] = "xMidYMid slice"
            attributes["focusable"] = "false"
            role = "img"
            attributes["aria-label"] = "Placeholder: 140x140"
        }
    }

    private fun DIV.svgFeaturette() {
        svg("bd-placeholder-img bd-placeholder-img-lg featurette-image img-fluid mx-auto") {
            attributes["width"] = "500"
            attributes["height"] = "500"
            attributes["preserveaspectratio"] = "xMidYMid slice"
            attributes["focusable"] = "false"
            role = "img"
            attributes["aria-label"] = "Placeholder: 500x500"
        }
    }
}