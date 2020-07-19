package com.yarchike.work_2_1

class PostData {
    companion object {

        fun getDataBase(): ArrayList<Post> {
            val list = ArrayList<Post>()

            list.add(Post(
                12, 1594585699570, "Мартынов Я.В.",
                "10 февраля, среда\n" +
                        "\n" +
                        "Львам так надоело терять людей! \n" +
                        "Им нужен тот, кто придет в их жизнь \n" +
                        "и скажет: 'Хочешь, не хочешь, а я остаюсь", 15,
                0, 5, isLike = false, isComment = false, isShare = false,
                adress = "Проспект Королева дом 5", coordinates = Pair(55.921606, 37.841268),type = PostTypes.Events))
            list.add(Post(
                13, 1594585699570, "Мартынов Я.В.",
                "https://www.youtube.com/watch?v=jaVljl8mdqI", 0,
                12, 5, isLike = false, isComment = false, isShare = false,
                adress = "Проспект Королева дом 5", coordinates = Pair(55.921606, 37.841268), type = PostTypes.YoutubeVideo
            ))
            list.add(Post(14, 1594585699570, "Мартынов Я.В.",
                "https://sun1-30.userapi.com/c631531/v631531139/5b0f/t3HG4Ql5dRc.jpg", 0,
                12, 5, isLike = false, isComment = false, isShare = false,
                adress = "Проспект Королева дом 5", coordinates = Pair(55.921606, 37.841268), type = PostTypes.SponsoredPosts, url = "https://vk.com/night_ghostss"))
            list.add(Post(
                14, 1594585699570, "Мартынов Я.В.",
                "10 февраля, среда\n" +
                        "\n" +
                        "Львам так надоело терять людей! \n" +
                        "Им нужен тот, кто придет в их жизнь \n" +
                        "и скажет: 'Хочешь, не хочешь, а я остаюсь", 15,
                0, 5, isLike = false, isComment = false, isShare = false,
                adress = "Проспект Королева дом 5", coordinates = Pair(55.921606, 37.841268),type = PostTypes.Events))
            list.add(Post(14, 1594585699570, "Мартынов Я.В.",
                "10 февраля, среда\n" +
                        "\n" +
                        "Львам так надоело терять людей! \n" +
                        "Им нужен тот, кто придет в их жизнь \n" +
                        "и скажет: 'Хочешь, не хочешь, а я остаюсь", 15,
                0, 5, isLike = false, isComment = false, isShare = false,
                adress = "Проспект Королева дом 5", coordinates = Pair(55.921606, 37.841268),type = PostTypes.Reposts, autorRepost = "Захаровская Евгения", dateRepost = 1595184329249 ))
            return list
        }

    }


}