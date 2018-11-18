# SpringBoot-sentencesAPI

RESTful API using Spring Boot

***

## Endpoint: /word_count_per_sentence 

Returns individual sentences along with a word count for the sentence. A sentence is any grouping of letters and words ending in a period, question mark or exclamation point. A word is text delimited by spaces. 


### Method:
POST

### URI: 
http://localhost:8080/word_count_per_sentence

### Content type: 
Application/JSON

### Request body:
```
{ 	
   "sentence":"pawan pinjarkar knows java. Pawan also knows node js! Does Pawan know python? Yes, he knows." 
} 
```
### Response:
```
{
    "individualSentences": {
        "pawan pinjarkar knows java": 4,
        "Pawan also knows node js": 5,
        "Does Pawan know python": 4,
        "Yes, he knows": 3
    }
}
```

***

## Endpoint: /total_letter_count

For each case-insensitive letter, return the number of times that letter appears in the entire text. E.g. the text contains 50 As, 40 Bs, etc.


### Method:
POST 

### URI:
http://localhost:8080/total_letter_count

### Content type:
Application/JSON

###Request body:
```
{ 	
   "sentence":"pawan pinjarkar knows java. Pawan also knows node js! Does Pawan know python? Yes, he knows." 
} 
```
### Response:
```
{
    "result": "The text contains 11 As, 0 Bs, 0 Cs, 2 Ds, 4 Es, 0 Fs, 0 Gs, 2 Hs, 1 Is, 3 Js, 5 Ks, 1 Ls, 0 Ms, 10 Ns, 8 Os, 5 Ps, 0 Qs, 2 Rs, 7 Ss, 1 Ts, 0 Us, 1 Vs, 7 Ws, 0 Xs, 2 Ys, 0 Zs"
}
```


