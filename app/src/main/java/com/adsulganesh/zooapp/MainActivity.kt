package com.adsulganesh.zooapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.animal_ticket.view.*

class MainActivity : AppCompatActivity() {

    var listOfAnimals = arrayListOf<Animal>()
    var adapter:AnimalAdapter ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //load Animals
        listOfAnimals.add(Animal("Baboon","Baboons are primates comprising the genus Papio, one of the 23 genera of Old World monkeys."
                                    ,R.drawable.baboon,false))
        listOfAnimals.add(Animal("Bulldog","The Bulldog, also known as the British Bulldog or English Bulldog, is a medium-sized dog breed."
                                    ,R.drawable.bulldog,false))
        listOfAnimals.add(Animal("Panda","The giant panda, also known as panda bear or simply panda, is a bear native to south central China."
                                    ,R.drawable.panda,false))
        listOfAnimals.add(Animal("Swallow Bird","The swallows, martins and saw-wings, or Hirundinidae, are a family of passerine birds found around the world on all continents, including occasionally in Antarctica."
                                    ,R.drawable.swallow_bird,false))
        listOfAnimals.add(Animal("White Tiger","The white tiger or bleached tiger is a pigmentation variant of the Bengal tiger, which is reported in the wild from time to time in the Indian states."
                                    ,R.drawable.white_tiger,true))
        listOfAnimals.add(Animal("Zebra","Zebras are several species of African equids united by their distinctive black-and-white striped coats."
                                    ,R.drawable.zebra,false))
        listOfAnimals.add(Animal("Lion","he lion is a species in the family Felidae; it is a muscular, deep-chested cat with a short, rounded head, a reduced neck and round ears, and a hairy tuft at the end of its tail."
                                    ,R.drawable.lion,true))
        adapter = AnimalAdapter(this,listOfAnimals)
        tvAnimalList.adapter = adapter
    }

    class AnimalAdapter:BaseAdapter{

        var context:Context
        var listOfAnimals = arrayListOf<Animal>()
        constructor(context: Context,listOfAnimals:ArrayList<Animal>){
            this.listOfAnimals = listOfAnimals
            this.context = context
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var animal = listOfAnimals[position]
            var inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            if (animal.isKiller == true){
                var myView = inflater.inflate(R.layout.killer_animal_ticket,null)
                myView.tvAnimalName.text = animal.name
                myView.tvAnimalDesc.text = animal.desc
                myView.ivAnimalImage.setImageResource(animal.image!!)
                myView.ivAnimalImage.setOnClickListener{
                    val intent = Intent(context,AnimalDetails::class.java)
                    intent.putExtra("name",animal.name)
                    intent.putExtra("desc",animal.desc)
                    intent.putExtra("image",animal.image!!)
                    context.startActivity(intent)
                }
                return myView
            }else{
                var myView = inflater.inflate(R.layout.animal_ticket,null)
                myView.tvAnimalName.text = animal.name
                myView.tvAnimalDesc.text = animal.desc
                myView.ivAnimalImage.setImageResource(animal.image!!)
                myView.ivAnimalImage.setOnClickListener {
                    val intent = Intent(context,AnimalDetails::class.java)
                    intent.putExtra("name",animal.name)
                    intent.putExtra("desc",animal.desc)
                    intent.putExtra("image",animal.image!!)
                    context.startActivity(intent)
                }
                return myView
            }
        }

        override fun getItem(position: Int): Any {
            return listOfAnimals[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return listOfAnimals.size
        }

    }
}