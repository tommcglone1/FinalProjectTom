import { Meal } from "./meal";
import { MealPlan } from "./meal-plan";

export class User {

  id: number;
  username: string;
  password: string;
  email: string;
  role: string;
  userMeals: Meal [];
  userMealPlans: MealPlan[];



  constructor(
    id: number = 0,
  username: string = '',
  password: string = '',
  email: string = '',
  role: string = '',
  userMeals: Meal [] = [],
  userMealPlans: MealPlan[] = []
  ) {
  this.id = id;
  this.username = username;
  this.password = password;
  this.email = email;
  this.role = role;
  this.userMeals = userMeals
  this.userMealPlans = userMealPlans

  }


  }
