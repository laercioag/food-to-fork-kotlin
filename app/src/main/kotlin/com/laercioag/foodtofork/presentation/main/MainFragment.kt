package com.laercioag.foodtofork.presentation.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.laercioag.foodtofork.R
import com.laercioag.foodtofork.extensions.setSupportActionBarTitle
import com.laercioag.foodtofork.presentation.base.BaseFragment
import com.laercioag.foodtofork.presentation.recipes.RecipesFragment
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : BaseFragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setSupportActionBarTitle(R.string.app_name)
        setupGoBtn()
    }

    private fun setupGoBtn() {
        goBtn.setOnClickListener { navigateToRecipesFragment() }
    }

    private fun navigateToRecipesFragment() {
        requireActivity().run {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, RecipesFragment.newInstance())
                .addToBackStack(null)
                .commit()
        }
    }

}
