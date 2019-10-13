package com.example.thirteen.controller;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.WebAsyncTask;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/handle")
public class HandleCardController {


  @ResponseBody
  @RequestMapping("/hello2")
  public String card2(@RequestBody String str){
    List<Card> cards = new ArrayList<>();
    try {
      JSONObject jsonObject = new JSONObject(str);
      int id = jsonObject.getInt("id");
      String cardStr = jsonObject.getString("card");
      String[] cardSplit = cardStr.split(" ");
      for (int i = 0; i < cardSplit.length; i++){
        cards.add(new Card(cardSplit[i]));
      }
      Player player = new Player();
      player.change(cards);
      JSONObject result = new JSONObject();
      JSONArray cardArray= new JSONArray();
      String str1 = "";
      String str2 = "";
      String str3 = "";
      for (int i = 0;i < player.choice.head.size(); i++){
        Card card = player.choice.head.get(i);
        str1 +=  card.toString();
        if (i < player.choice.head.size() - 1)
          str1 += " ";
      }
      for (int i = 0;i < player.choice.mid.size(); i++){
        Card card = player.choice.mid.get(i);
        str2 +=  card.toString();
        if (i < player.choice.mid.size() - 1)
          str2 += " ";
      }
      for (int i = 0;i < player.choice.end.size(); i++){
        Card card = player.choice.end.get(i);
        str3 +=  card.toString();
        if (i < player.choice.end.size() - 1)
          str3 += " ";
      }
      cardArray.put(str1);
      cardArray.put(str2);
      cardArray.put(str3);
      result.put("card",cardArray);
      return result.toString();
    } catch (JSONException e) {
      e.printStackTrace();
    }
    return "";
  }
}
