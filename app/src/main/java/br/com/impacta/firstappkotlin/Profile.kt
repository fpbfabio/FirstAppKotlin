package br.com.impacta.firstappkotlin

data class Profile(
    val name: String,
    val age: Int,
    val location: String,
    val coverImage: Photo,
    val photos: List<Photo>,
    val curiosities: List<Curiosity>
)

data class Photo(
    val imageURL: String,
    val description: String
)

data class Curiosity(
    val title: String,
    val description: String
)