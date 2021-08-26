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

        ArrayList<GeometryExplanation> listExplanation = new ArrayList<>();

        ArrayList<GeometryConcept> listConcepts = new ArrayList<>();
        listConcepts.add(new GeometryConcept("Планиметрия", R.drawable.planimetria));
        listConcepts.add(new GeometryConcept("Стереометрия", R.drawable.stereometry));

        AdapterExplanation adapterExplanation = new AdapterExplanation(listExplanation, getContext());
        adapterExplanation.setOnItemClickListener(new AdapterExplanation.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                switch(listExplanation.get(position).getName()){
                    case "Произвольный треугольник": //Новая активность с инфой
                        break;
                    case "Равнобедренный треугольник":
                        break;
                    case "Равносторонний треугольник":
                        break;
                    case "Прямоугольный треугольник":
                        break;
                    case "Вписанный и описанный треугольник":
                        break;
                    case "Замечательные линии треугольника":
                        break;
                    case "Равенство и подобие":
                        break;
                    //....
                }
            }
        });

        AdapterConcepts adapterConcepts = new AdapterConcepts(listConcepts, getContext());
        adapterConcepts.setOnItemClickListener(new AdapterConcepts.OnItemClickListener() {
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
                        adapterConcepts.setList(listConcepts);
                        adapterConcepts.notifyDataSetChanged();
                        break;
                    case "Стереометрия":
                        getActivity().setTitle("Стереометрия");
                        listConcepts.clear();
                        listConcepts.add(new GeometryConcept("Прямые и плоскости", R.drawable.ic_baseline_article_24)); //Добавить картинки
                        listConcepts.add(new GeometryConcept("Призма", R.drawable.ic_baseline_article_24));
                        listConcepts.add(new GeometryConcept("Пирамида", R.drawable.ic_baseline_article_24));
                        listConcepts.add(new GeometryConcept("Шар", R.drawable.ic_baseline_article_24));
                        listConcepts.add(new GeometryConcept("Векторы и координаты", R.drawable.ic_baseline_article_24));
                        adapterConcepts.setList(listConcepts);
                        adapterConcepts.notifyDataSetChanged();
                        break; //сделать функцию назад
                    case "Треугольники":
                        getActivity().setTitle("Треугольники");
                        listExplanation.clear();
                        listExplanation.add(new GeometryExplanation("Произвольный треугольник", "Периметр, площадь, теоремы"));
                        listExplanation.add(new GeometryExplanation("Равнобедренный треугольник", "Определение и свойства"));
                        listExplanation.add(new GeometryExplanation("Равносторонний треугольник", "Определение и свойства"));
                        listExplanation.add(new GeometryExplanation("Прямоугольный треугольник", "Определение и свойства"));
                        listExplanation.add(new GeometryExplanation("Вписанный и описанный треугольник", "Формулы для связи с окружностями"));
                        listExplanation.add(new GeometryExplanation("Замечательные линии треугольника", "Медиана, биссектриса, высота, средняя линия"));
                        listExplanation.add(new GeometryExplanation("Равенство и подобие", "Признаки равенства и подобия треугольников"));
                        recyclerView.setAdapter(adapterExplanation);
                        break;
                    case "Прямые":
                        break;
                    case "Углы":
                        break;
                    case "Четырехугольники":
                        break;
                    case "Окружность и круг":
                        break;
                    case "Многоугольники":
                        break;
                    case "Векторы":
                        break;
                    case "Прямые и плоскости":
                        break;
                    case "Призма":
                        break;
                    case "Пирамида":
                        break;
                    case "Шар":
                        break;
                    case "Векторы и координаты":
                        break;
                }
            }
        });

        recyclerView.setAdapter(adapterConcepts);
    }

}
