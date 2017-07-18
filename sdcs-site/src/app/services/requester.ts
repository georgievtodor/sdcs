import { Injectable } from '@angular/core';
import { Headers, Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/Rx';
import 'rxjs/add/observable/throw';

@Injectable()
export class Requester {
    headers: Headers = new Headers({
        'Content-Type': 'application/json'
    });
    api_url = 'http://localhost:8080/';

    constructor(private http: Http) { }

    private getJson(response: Response) {
        return response.json();
    }

    private checkForError(response: Response): Response | Observable<any> {
        if (response.status >= 200 && response.status <= 301) {
            return response;
        } else {
            const error = new Error(response.statusText);
            error['response'] = response;
            console.error(error);
            throw error;
        }
    }

    get(path: string): Observable<any> {
        return this.http.get(`${this.api_url}${path}`, { headers: this.headers })
            .map(this.checkForError)
            .catch(err => Observable.throw(err))
            .map(this.getJson);
    }

    post(path: string, body: any): Observable<any> {
        return this.http.post(
            `${this.api_url}${path}`,
            JSON.stringify(body),
            { headers: this.headers })
            .map(this.checkForError)
            .catch(err => Observable.throw(err))
            .map(this.getJson)
    }

    put(path: string, body: any): Observable<any> {
        return this.http.put(`${this.api_url}${path}`,
            JSON.stringify(body),
            { headers: this.headers })
            .map(this.checkForError)
            .catch(err => Observable.throw(err))
            .map( resp => {
                return resp._body;
            })
    }

    setHeaders(headers) {
        Object.keys(headers).forEach(header => this.headers.set(header, headers[header]));
    }

    delete(path: string): Observable<any> {
        return this.http.delete(
            `${this.api_url}${path}`,
            { headers: this.headers })
            .map(this.checkForError)
            .catch(err => Observable.throw(err))
            .map(this.getJson)
    }
}


