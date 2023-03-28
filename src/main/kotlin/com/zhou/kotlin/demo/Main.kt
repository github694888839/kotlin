package com.zhou.kotlin.demo

import java.net.URL

class Main {
}

fun main() {
    //println("${"appver".hashCode()}")
    val baseUrl = URL("https://152vod-adaptive.akamaized.net/exp=1672134754~acl=%2F01cbd422-a6d6-4630-b060-645f52b50427%2F%2A~hmac=d796ed5d06b0d2703000c07a04502e9c74ac24ca377c546e8fa20d0a9fad5e79/01cbd422-a6d6-4630-b060-645f52b50427/sep/video/5224df8d,ea071af4,2017c0e6,3a484c76,ec3c4857/audio/857eab73,9d12b2e0,df23cc31/master.json?query_string_ranges=1&base64_init=1")

    val url = URL(baseUrl,"../../../nihgao")
    println(url.toString())
}