package com.tencent.ang.fmt

import com.tencent.ang.dto.EConfigType
import com.tencent.ang.dto.ProfileItem
import com.tencent.ang.dto.V2rayConfig
import com.tencent.ang.util.JsonUtil

object CustomFmt : FmtBase() {
    /**
     * Parses a JSON string into a ProfileItem object.
     *
     * @param str the JSON string to parse
     * @return the parsed ProfileItem object, or null if parsing fails
     */
    fun parse(str: String): ProfileItem? {
        val config = ProfileItem.create(EConfigType.CUSTOM)

        val fullConfig = JsonUtil.fromJson(str, V2rayConfig::class.java)
        val outbound = fullConfig.getProxyOutbound()

        config.remarks = fullConfig?.remarks ?: System.currentTimeMillis().toString()
        config.server = outbound?.getServerAddress()
        config.serverPort = outbound?.getServerPort().toString()

        return config
    }
}