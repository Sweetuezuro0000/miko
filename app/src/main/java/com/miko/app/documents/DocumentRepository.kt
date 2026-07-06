package com.miko.app.documents

class DocumentRepository {

    private val documents = mutableListOf<Document>()

    fun add(document: Document) {

        documents.add(document)

    }

    fun getAll(): List<Document> {

        return documents

    }

    fun clear() {

        documents.clear()

    }

}
