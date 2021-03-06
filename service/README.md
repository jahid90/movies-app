# Movies Service

The backend for the movies app. Fetches information about movies and tv series from TMDb.org.

## APIs

* `/api/v1/movies/popular` - popular movies for the week
```sh
$ curl -v GET http://localhost:8080/api/v1/movies/popular | jq
```
* `/api/v1/series/popular` - popular tv series for the week
```sh
$ curl -v GET http://localhost:8080/api/v1/series/popular | jq
```

## Running the Service
The service needs an api key to make calls to TMDb. The key is fetched from an environment variable named `OMDB_API_KEY`.
```sh
$ export OMDB_API_KEY=<api key>
```

All the below commands expect the availabilty of the [just](https://github.com/jahid90/just-cli) command line tool on PATH. Alternatively, look into the `just.yaml` file and run the equivalent command.

### Generating the jar
```sh
$ just build
```

### Running the service
```sh
$ just run
```

### Running the service as a docker containers
```sh
$ just docker:build
$ just docker:run
```

To stop the container
```sh
$ just docker:stop
```
