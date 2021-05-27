package com.example.geometry;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TheoryClass extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.theory, container, false);
    }
    @Override
    public void onStart() {
        super.onStart();
        RecyclerView recyclerView = getView().findViewById(R.id.recyclerView);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(), LinearLayout.VERTICAL);
        dividerItemDecoration.setDrawable(getResources().getDrawable(R.drawable.divider));
        recyclerView.addItemDecoration(dividerItemDecoration);
        ArrayList<GeometryConcept> listConcepts = new ArrayList<>();
        listConcepts.add(new GeometryConcept("Планиметрия", R.drawable.planimetria));
        listConcepts.add(new GeometryConcept("Стереометрия", R.drawable.stereometry));
        AdapterConcepts adapter = new AdapterConcepts(listConcepts, getContext());
        adapter.setOnItemClickListener(new AdapterConcepts.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                switch(listConcepts.get(position).getName()){
                    case "Планиметрия":
                        getActivity().setTitle("Планиметрия");
                        listConcepts.clear();
                        listConcepts.add(new GeometryConcept("Прямые", R.drawable.ic_baseline_article_24)); //Добавить картинки
                        listConcepts.add(new GeometryConcept("Углы", R.drawable.ic_baseline_article_24));
                        listConcepts.add(new GeometryConcept("Треугольники", R.drawable.ic_baseline_article_24));
                        listConcepts.add(new GeometryConcept("Четырехугольники", R.drawable.ic_baseline_article_24));
                        listConcepts.add(new GeometryConcept("Окружность и круг", R.drawable.ic_baseline_article_24));
                        listConcepts.add(new GeometryConcept("Многоугольники", R.drawable.ic_baseline_article_24));
                        listConcepts.add(new GeometryConcept("Векторы", R.drawable.ic_baseline_article_24));
                        adapter.setList(listConcepts);
                        adapter.notifyDataSetChanged();
                        break;
                    case "Стереометрия":
                        getActivity().setTitle("Стереометрия");
                        listConcepts.clear();
                        listConcepts.add(new GeometryConcept("Прямые и плоскости", R.drawable.ic_baseline_article_24)); //Добавить картинки
                        listConcepts.add(new GeometryConcept("Призма", R.drawable.ic_baseline_article_24));
                        listConcepts.add(new GeometryConcept("Пирамида", R.drawable.ic_baseline_article_24));
                        listConcepts.add(new GeometryConcept("Шар", R.drawable.ic_baseline_article_24));
                        listConcepts.add(new GeometryConcept("Векторы и координаты", R.drawable.ic_baseline_article_24));
                        adapter.setList(listConcepts);
                        adapter.notifyDataSetChanged();
                        break; //Добавить остальные понятия + сделать функцию назад
                    case "Треугольники":
                        getActivity().setTitle("Треугольники");


                }
            }
        });
        recyclerView.setAdapter(adapter);
    }

}
