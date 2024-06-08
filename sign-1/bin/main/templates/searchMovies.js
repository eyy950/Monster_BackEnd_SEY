function searchMovies() {

    // TMDB Api
    const options = {
        method: 'GET',
        headers: {
            accept: 'application/json',
            Authorization: 'Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIyNmM2ODZkMDdhMTcxNDUyZWUyYzM2MGUwODFjNjAxMyIsInN1YiI6IjY0NzRjMGFhNWNkMTZlMDBiZjEyNDQ2OSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.qgYpZS6S6GHYU8eq2rRevqoZz5g80tZ7hZ5KJ3soHVU'
        }
    };
    const url = 'https://api.themoviedb.org/3/movie/top_rated?language=en-US&page=1';
}
