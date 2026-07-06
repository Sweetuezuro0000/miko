package com.miko.app.documents

object DocumentSearch {

    fun search(

        list: List<Document>,

        query: String

    ): List<Document> {

        return list.filter {

            it.name.contains(query, true)

        }

    }

}
