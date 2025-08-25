package com.tencent.admin.dto

data class ConfigResult(
    var status: Boolean,
    var guid: String? = null,
    var content: String = "",
    var socksPort: Int? = null,
)

