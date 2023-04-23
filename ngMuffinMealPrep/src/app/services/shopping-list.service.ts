import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { AuthService } from './auth.service';
import { User } from '../models/user';
import { Observable, catchError, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ShoppingListService {

  private url = environment.baseUrl + 'api/myShoppingList';
  constructor(private http: HttpClient, private auth: AuthService) { }


 update(user: User|null): Observable<User>{
  return this.http.put<User>(this.url + '/' + user?.id, user, this.getHttpOptions()).pipe(
    catchError((err: any) => {
      console.log(err);
      return throwError(
        () => new Error('MealService.createGroceryForMeal(): error adding grocery to meal: ' + err)
      );
    })
  );
 }



 getHttpOptions() {
  let options = {
    headers: {
      Authorization: 'Basic ' + this.auth.getCredentials(),
      'X-Requested-With': 'XMLHttpRequest',
    },
  };
  return options;
}
}