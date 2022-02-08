package com.example.telegramappui.model

class Contact() {
    var profile: Int = 0
    var fullname: String? = null
    var online: String? = null

    constructor(profile: Int, fullname: String, online: String?): this(){
        this.profile = profile
        this.fullname = fullname
        this.online = online
    }
}