#Heroku
# lier le projet
-   heroku git:remote -a mini-rss-api
-   git add .
-   git push heroku main
# Ajouter la base postgres dans le depot
-   heroku addons
-   heroku config
-   heroku pg
-   heroku pg:psql
#lien
- https://mini-rss-api.herokuapp.com/
 
#logs
- heroku logs --tail

#push
- git push heroku main

#API

- Verifier status Api 

-[https://mini-rss-api.herokuapp.com/api/v1/rss/status](https://mini-rss-api.herokuapp.com/api/v1/rss/status)

## charger le flux RSS (uniquement les nouveaux articles )  

-[https://mini-rss-api.herokuapp.com/api/v1/rss/refresh](https://mini-rss-api.herokuapp.com/api/v1/rss/refresh)

## lister les articles 

-[https://mini-rss-api.herokuapp.com/api/v1/rss/items](https://mini-rss-api.herokuapp.com/api/v1/rss/items)
