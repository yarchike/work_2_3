package com.yarchike.work_2_1

class PostData{
    companion object{

        fun getDataBase(): ArrayList<Post>{
            val list = ArrayList<Post>()
            var post:Post = Post(12, 1594585699570, "Мартынов Я.В.",
                "10 февраля, среда\n" +
                        "\n" +
                        "Львам так надоело терять людей! \n" +
                        "Им нужен тот, кто придет в их жизнь \n" +
                        "и скажет: 'Хочешь, не хочешь, а я остаюсь", 15,
                0, 5, isLike = false, isComment = false, isShare = false,
                adress = "Проспект Королева дом 5", coordinates = Pair(55.921606, 37.841268))
            list.add(post)
            var post2 :Post = Post(12, 1594585699570, "Мартынов Я.В.",
                "Тролололошечка", 0,
                12, 5, isLike = false, isComment = false, isShare = false,
                adress = "Проспект Королева дом 5", coordinates = Pair(55.921606, 37.841268))

            list.add(post2)
            return  list
        }

    }


}