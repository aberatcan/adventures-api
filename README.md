# Getting Started

### Api Documentation
This project is a sample of RestAPI 
Application that created using Java Spring framework.
### Guides
#### Starting server
Run this command in project root directory to start the server:
```
./mvnw spring-boot:run
```
The server is running on ` http://localhost:4001`

You can modify the port by updating `src/main/resources/application.properties`

When the server is run, it will automatically initialize in-memory database using h2 database and populate mock data using `src/main/resources/data.sql` file.

In this project, we build an API that functions as a travel log. The API should allow you to create entries for new places you have visited, retrieve and update existing entries, and delete entries that may have been entered in error.

The fields of Adventure object:
```
{
    "id": 350,
    "date": "05/07/2022",
    "country": "Turkey",
    "city": "Istanbul",
    "state": "Uskudar",
    "numPhotos": 68,
    "blogCompleted": true
}
```

You can get all adventures with using `curl` in command-line with this command:
```
curl  http://localhost:4001/travelAdventures
```

```
[
    {
        "id": 1,
        "date": "/07/2017",
        "country": "China",
        "city": "Xinying",
        "state": "",
        "numPhotos": 93,
        "blogCompleted": false
    },
    {
        "id": 2,
        "date": "/26/2018",
        "country": "Indonesia",
        "city": "Ketapang",
        "state": "",
        "numPhotos": 53,
        "blogCompleted": false
    },
    {
        "id": 3,
        "date": "/18/2017",
        "country": "Greece",
        "city": "KallithÃ©a",
        "state": "",
        "numPhotos": 31,
        "blogCompleted": true
    },
    {
        "id": 4,
        "date": "/21/2019",
        "country": "China",
        "city": "Jinjiang",
        "state": "",
        "numPhotos": 38,
        "blogCompleted": true
    },
    {
        "id": 5,
        "date": "/27/2020",
        "country": "Panama",
        "city": "Capira",
        "state": "",
        "numPhotos": 36,
        "blogCompleted": true
    },
    {
        "id": 6,
        "date": "/23/2018",
        "country": "Japan",
        "city": "Itoigawa",
        "state": "",
        "numPhotos": 81,
        "blogCompleted": true
    },
    {
        "id": 7,
        "date": "/16/2017",
        "country": "Uruguay",
        "city": "Salto",
        "state": "",
        "numPhotos": 43,
        "blogCompleted": false
    }
    ...
]
```

You can get adventures by country:
```
curl http://localhost:4001/travelAdventures/byCountry/Ukraine
```

```
[
    {
        "id": 105,
        "date": "11/05/2018",
        "country": "Ukraine",
        "city": "Medzhibozh",
        "state": "",
        "numPhotos": 22,
        "blogCompleted": true
    },
    {
        "id": 144,
        "date": "04/19/2018",
        "country": "Ukraine",
        "city": "Verkhnyachka",
        "state": "",
        "numPhotos": 56,
        "blogCompleted": true
    },
    {
        "id": 147,
        "date": "05/20/2019",
        "country": "Ukraine",
        "city": "Bilopillya",
        "state": "",
        "numPhotos": 5,
        "blogCompleted": true
    },
    {
        "id": 153,
        "date": "09/24/2019",
        "country": "Ukraine",
        "city": "Zarya",
        "state": "",
        "numPhotos": 72,
        "blogCompleted": true
    },
    {
        "id": 249,
        "date": "06/26/2019",
        "country": "Ukraine",
        "city": "Marshintsy",
        "state": "",
        "numPhotos": 31,
        "blogCompleted": false
    },
    {
        "id": 283,
        "date": "10/01/2019",
        "country": "Ukraine",
        "city": "Yelyzavethradka",
        "state": "",
        "numPhotos": 41,
        "blogCompleted": false
    },
    {
        "id": 310,
        "date": "07/27/2016",
        "country": "Ukraine",
        "city": "Ukrainka",
        "state": "",
        "numPhotos": 92,
        "blogCompleted": true
    },
    {
        "id": 318,
        "date": "02/17/2018",
        "country": "Ukraine",
        "city": "Krasnyy Lyman",
        "state": "",
        "numPhotos": 36,
        "blogCompleted": true
    }
]
```
You can get adventures by state:
```
curl http://localhost:4001/travelAdventures/byState?state=Ontario
```

```
[
    {
        "id": 143,
        "date": "12/24/2019",
        "country": "Canada",
        "city": "Petawawa",
        "state": "Ontario",
        "numPhotos": 38,
        "blogCompleted": false
    }
]
```


You can get adventure by id:
```
curl http://localhost:4001/travelAdventures/61
```

```
{
    "id": 61,
    "date": "9/05/2018",
    "country": "Burkina Faso",
    "city": "Ouagadougou",
    "state": "",
    "numPhotos": 67,
    "blogCompleted": false
}
```

You can create adventure:
```
curl -d '{ "date": "05/05/2022", "country": "Korea", "city": "Jeju City", "state": "Jeju Province", "numPhotos": "96", "blogCompleted": "false" }'  -H "Content-Type: application/json" localhost:4001/travelAdventures
```

You can delete adventure by id:
```
curl -X DELETE localhost:4001/travelAdventures/{id}
```

