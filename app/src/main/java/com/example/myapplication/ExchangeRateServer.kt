package com.example.myapplication

import java.io.Serializable

class ExchangeRateServer(
    var result: String? = null,
    var cur_unit: String? = null,
    var cur_nm: String? = null,
    var kftc_deal_bas_r: String? = null
) : Serializable