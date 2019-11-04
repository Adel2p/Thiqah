package com.ebc.ipnapplication.ui.base.interactor

import com.ebc.ipnapplication.data.network.ApiHelper
import com.ebc.ipnapplication.data.preferences.PreferenceHelper


/**
 * Created by Mohamed Adel on 04/01/18.
 */
open class BaseInterActor() : MVPInterActor {

    protected lateinit var preferenceHelper: PreferenceHelper
    protected lateinit var apiHelper: ApiHelper

    constructor(preferenceHelper: PreferenceHelper, apiHelper: ApiHelper) : this() {
        this.preferenceHelper = preferenceHelper
        this.apiHelper = apiHelper
    }

}