package com.ebc.ipnapplication.ui.base.presenter

import com.ebc.ipnapplication.ui.base.interactor.MVPInterActor
import com.ebc.ipnapplication.ui.base.view.MVPView

/**
 * Created by Mohamed Adel on 04/01/18.
 */
interface MVPPresenter<V : MVPView, I : MVPInterActor> {

    fun onAttach(view: V?)

    fun onDetach()

    fun getView(): V?

}