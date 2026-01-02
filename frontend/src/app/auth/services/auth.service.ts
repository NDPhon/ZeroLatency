import { Injectable } from "@angular/core";
import { BehaviorSubject, Observable, tap } from "rxjs";
import { AuthResponse, LoginRequest } from "../auth.model";
import { HttpClient } from "@angular/common/http";

@Injectable({
    providedIn: "root"
})
export class AuthService {
    private apiURL = 'http://localhost:8080/api/users';

    private currentUserSubject = new BehaviorSubject<any> (this.getUserFromStorage());
    public currentUser$ = this.currentUserSubject.asObservable();

    private isAuthenticatedSubject = new BehaviorSubject<boolean> (!!this.getToken());
    public isAuthenticated$ = this.isAuthenticatedSubject.asObservable();


    constructor(private http: HttpClient) {}


    login(username: string, password: string): Observable<AuthResponse> {
        const credentials : LoginRequest = {username, password};
        return this.http.post<AuthResponse>(`${this.apiURL}/login`, credentials).pipe(
            tap((response) => {
                    this.setCurrentUser(response.user);
                    this.setToken(response.token);
                    this.currentUserSubject.next(response.user);
                    this.isAuthenticatedSubject.next(true);
                }
            )
        );
    }

    logout(): void {
        this.removeToken();
        this.removeCurrentUser();
        this.currentUserSubject.next(null);
        this.isAuthenticatedSubject.next(false);

    }

    isAuthenticated(): boolean {
        return !!this.getToken();
    }

    getToken(): string | null {
        if (typeof window === 'undefined') return null;
        return localStorage.getItem('authToken')
    }

    setToken(token: string): void {
        if (typeof window === 'undefined') return;
        localStorage.setItem('authToken', token);
    }

    private removeToken(): void {
        if (typeof window === 'undefined') return;
        localStorage.removeItem('authToken');
    }

    private setCurrentUser(user: any): void {
        if (typeof window === 'undefined') return;
        localStorage.setItem('currentUser', JSON.stringify(user));
    }

    private removeCurrentUser(): void {
        if (typeof window === 'undefined') return;
        localStorage.removeItem('currentUser');
    }

    getCurrentUser(): any {
        return this.currentUserSubject.value;
    }

    private getUserFromStorage(): any {
        if (typeof window === 'undefined') return null;
        const user = localStorage.getItem('currentUser');
        return user ? JSON.parse(user) : null;
    }
}