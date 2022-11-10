package com.example.composedemo.ui.fragment.breedslist

import androidx.lifecycle.ViewModel
import com.example.composedemo.data.model.BreedModel

class BreedListVM : ViewModel() {

    private val images = listOf(
        "https://images.dog.ceo/breeds/hound-english/n02089973_973.jpg",
        "https://images.dog.ceo/breeds/hound-english/n02089973_981.jpg",
        "https://images.dog.ceo/breeds/hound-english/n02089973_99.jpg",
        "https://images.dog.ceo/breeds/hound-ibizan/n02091244_3921.jpg",
        "https://images.dog.ceo/breeds/hound-ibizan/n02091244_3939.jpg",
        "https://images.dog.ceo/breeds/hound-ibizan/n02091244_4015.jpg",
        "https://images.dog.ceo/breeds/hound-ibizan/n02091244_4031.jpg",
        "https://images.dog.ceo/breeds/hound-ibizan/n02091244_4033.jpg",
        "https://images.dog.ceo/breeds/hound-ibizan/n02091244_4086.jpg",
        "https://images.dog.ceo/breeds/hound-ibizan/n02091244_4107.jpg",
        "https://images.dog.ceo/breeds/hound-ibizan/n02091244_4110.jpg",
        "https://images.dog.ceo/breeds/hound-ibizan/n02091244_4177.jpg",
        "https://images.dog.ceo/breeds/hound-ibizan/n02091244_4221.jpg",
        "https://images.dog.ceo/breeds/hound-ibizan/n02091244_4242.jpg",
        "https://images.dog.ceo/breeds/hound-ibizan/n02091244_4268.jpg",
        "https://images.dog.ceo/breeds/hound-ibizan/n02091244_4281.jpg",
        "https://images.dog.ceo/breeds/hound-ibizan/n02091244_430.jpg",
        "https://images.dog.ceo/breeds/hound-ibizan/n02091244_4367.jpg",
        "https://images.dog.ceo/breeds/hound-ibizan/n02091244_4394.jpg",
        "https://images.dog.ceo/breeds/hound-ibizan/n02091244_4395.jpg",
        "https://images.dog.ceo/breeds/hound-ibizan/n02091244_440.jpg",
        "https://images.dog.ceo/breeds/hound-ibizan/n02091244_443.jpg",
        "https://images.dog.ceo/breeds/hound-ibizan/n02091244_448.jpg",
        "https://images.dog.ceo/breeds/hound-ibizan/n02091244_4644.jpg",
        "https://images.dog.ceo/breeds/hound-ibizan/n02091244_5238.jpg",
        "https://images.dog.ceo/breeds/hound-ibizan/n02091244_530.jpg",
        "https://images.dog.ceo/breeds/hound-ibizan/n02091244_5400.jpg",
        "https://images.dog.ceo/breeds/hound-ibizan/n02091244_5488.jpg",
        "https://images.dog.ceo/breeds/hound-ibizan/n02091244_5491.jpg",
        "https://images.dog.ceo/breeds/hound-ibizan/n02091244_5517.jpg",
        "https://images.dog.ceo/breeds/hound-ibizan/n02091244_5571.jpg",
        "https://images.dog.ceo/breeds/hound-ibizan/n02091244_5601.jpg",
        "https://images.dog.ceo/breeds/hound-ibizan/n02091244_5637.jpg",
        "https://images.dog.ceo/breeds/hound-ibizan/n02091244_5638.jpg",
        "https://images.dog.ceo/breeds/hound-ibizan/n02091244_61.jpg",
        "https://images.dog.ceo/breeds/hound-ibizan/n02091244_645.jpg",
        "https://images.dog.ceo/breeds/hound-ibizan/n02091244_678.jpg",
        "https://images.dog.ceo/breeds/hound-ibizan/n02091244_716.jpg",
        "https://images.dog.ceo/breeds/hound-ibizan/n02091244_736.jpg",
        "https://images.dog.ceo/breeds/hound-ibizan/n02091244_743.jpg",
        "https://images.dog.ceo/breeds/hound-ibizan/n02091244_746.jpg",
        "https://images.dog.ceo/breeds/hound-ibizan/n02091244_756.jpg",
        "https://images.dog.ceo/breeds/hound-ibizan/n02091244_784.jpg",
        "https://images.dog.ceo/breeds/hound-ibizan/n02091244_822.jpg",
        "https://images.dog.ceo/breeds/hound-ibizan/n02091244_85.jpg",
        "https://images.dog.ceo/breeds/hound-ibizan/n02091244_86.jpg",
        "https://images.dog.ceo/breeds/hound-ibizan/n02091244_873.jpg",
        "https://images.dog.ceo/breeds/hound-ibizan/n02091244_879.jpg",
        "https://images.dog.ceo/breeds/hound-ibizan/n02091244_939.jpg",
        "https://images.dog.ceo/breeds/hound-ibizan/n02091244_966.jpg",
        "https://images.dog.ceo/breeds/hound-plott/hhh-23456.jpeg",
        "https://images.dog.ceo/breeds/hound-plott/hhh_plott002.jpg",
        "https://images.dog.ceo/breeds/hound-walker/n02089867_1029.jpg",
        "https://images.dog.ceo/breeds/hound-walker/n02089867_1048.jpg",
        "https://images.dog.ceo/breeds/hound-walker/n02089867_1062.jpg",
        "https://images.dog.ceo/breeds/hound-walker/n02089867_1079.jpg",
        "https://images.dog.ceo/breeds/hound-walker/n02089867_1082.jpg",
        "https://images.dog.ceo/breeds/hound-walker/n02089867_1105.jpg",
        "https://images.dog.ceo/breeds/hound-walker/n02089867_1133.jpg",
        "https://images.dog.ceo/breeds/hound-walker/n02089867_1208.jpg",
        "https://images.dog.ceo/breeds/hound-walker/n02089867_1212.jpg",
        "https://images.dog.ceo/breeds/hound-walker/n02089867_1225.jpg",
        "https://images.dog.ceo/breeds/hound-walker/n02089867_1240.jpg",
        "https://images.dog.ceo/breeds/hound-walker/n02089867_1243.jpg",
        "https://images.dog.ceo/breeds/hound-walker/n02089867_126.jpg",
        "https://images.dog.ceo/breeds/hound-walker/n02089867_1295.jpg",
        "https://images.dog.ceo/breeds/hound-walker/n02089867_1310.jpg",
        "https://images.dog.ceo/breeds/hound-walker/n02089867_1345.jpg",
        "https://images.dog.ceo/breeds/hound-walker/n02089867_1352.jpg",
        "https://images.dog.ceo/breeds/hound-walker/n02089867_1368.jpg",
        "https://images.dog.ceo/breeds/hound-walker/n02089867_1381.jpg",
        "https://images.dog.ceo/breeds/hound-walker/n02089867_1987.jpg",
        "https://images.dog.ceo/breeds/hound-walker/n02089867_1988.jpg"
    )

    private fun generateBreedsList(): List<BreedModel> = List(images.size) { i ->
        BreedModel(
            name = "Breed ${i + 1}",
            imageUrls = listOf(images[i]),
            subBreeds = if (i == 3) {
                listOf("Sub Breed1", "Sub Breed2")
            } else null,
            breedId = i
        )
    }


//    private val _breedsList = generateBreedsList().toMutableStateList()
//    val breedsList: MutableList<BreedModel>
//        get() = _breedsList

    val breedsList: List<BreedModel> = generateBreedsList()

}