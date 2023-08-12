package com.example.weathersearchtesttask.ui.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.coroutineScope
import com.example.weathersearchtesttask.databinding.FragmentSearchBinding
import com.example.weathersearchtesttask.ui.view.adapters.SearchAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment() {

   private var _binding: FragmentSearchBinding? = null
   private val binding by lazy { _binding!! }
   private val viewModel by viewModels<SearchViewModel>()
   private val searchAdapter = SearchAdapter()

   override fun onCreateView(
       inflater: LayoutInflater, container: ViewGroup?,
       savedInstanceState: Bundle?
   ): View {
      _binding = FragmentSearchBinding.inflate(inflater, container, false)
      return binding.root
   }

   override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
      super.onViewCreated(view, savedInstanceState)

      initSearchView()
      initAdapter()
      initViewState()

   }

   private fun initAdapter() {
      binding.rv.adapter = searchAdapter
   }

   private fun initSearchView() {
      binding.searchview.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
         override fun onQueryTextSubmit(s: String?): Boolean {
            s?.let {
               viewModel.getSearchMeals(it)
            }
            return false
         }

         override fun onQueryTextChange(p0: String?): Boolean {
            return false
         }
      })
   }

   private fun initViewState() {
      lifecycle.coroutineScope.launchWhenCreated {
         viewModel.mealSearchList.collect { state ->
            if (state.isLoading) {
               binding.apply {
                  lottieSearch.isVisible = true
                  rv.isVisible = false
                  lottieError404.isVisible = false
               }

            }
            if (state.error.isNotBlank()) {
               binding.apply {
                  lottieSearch.isVisible = false
                  lottieError404.isVisible = true
                  rv.isVisible = false
               }
               Toast.makeText(requireContext(), state.error, Toast.LENGTH_SHORT).show()
            }

            state.data?.let {

               if (it.isEmpty()) {
                  binding.apply {
                     lottieSearch.isVisible = true
                     lottieError404.isVisible = false
                  }
               }
               binding.apply {
                  lottieSearch.isVisible = false
                  lottieError404.isVisible = false
                  rv.isVisible = true
               }
               searchAdapter.setContentList(it.toMutableList())
            }


         }
      }
   }

   override fun onDestroyView() {
      super.onDestroyView()
      _binding = null
   }

}