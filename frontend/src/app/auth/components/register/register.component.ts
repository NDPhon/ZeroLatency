import { Component, OnInit, Inject, PLATFORM_ID } from '@angular/core';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';
import { CommonModule, isPlatformBrowser } from '@angular/common';

@Component({
    selector: 'app-register',
    standalone: true,
    imports: [CommonModule, ReactiveFormsModule, RouterLink],
    templateUrl: './register.component.html',
    styleUrl: './register.component.css',
})
export class RegisterComponent implements OnInit {
    form!: FormGroup;
    isSubmitting = false;
    showSuccess = false;
    errorMessage: string | null = null;
    showPassword = false;
    showConfirmPassword = false;
    private isBrowser: boolean;

    constructor(
        private fb: FormBuilder,
        private router: Router,
        @Inject(PLATFORM_ID) platformId: Object
    ) {
        this.isBrowser = isPlatformBrowser(platformId);
    }

    ngOnInit(): void {
        this.form = this.fb.group({
            username: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(20)]],
            email: ['', [Validators.required, Validators.email]],
            password: ['', [Validators.required, Validators.minLength(8)]],
            confirmPassword: ['', [Validators.required]],
            agreeTerms: [false, [Validators.requiredTrue]],
        }, { validators: this.passwordMatchValidator });
    }

    passwordMatchValidator(form: FormGroup) {
        const password = form.get('password');
        const confirmPassword = form.get('confirmPassword');
        if (password && confirmPassword && password.value !== confirmPassword.value) {
            confirmPassword.setErrors({ passwordMismatch: true });
        }
        return null;
    }

    togglePasswordVisibility(field: 'password' | 'confirm'): void {
        if (field === 'password') {
            this.showPassword = !this.showPassword;
        } else {
            this.showConfirmPassword = !this.showConfirmPassword;
        }
    }

    onSubmit(): void {
        if (this.form.invalid) {
            return;
        }

        this.isSubmitting = true;
        this.errorMessage = null;

        // Simulate registration API call
        setTimeout(() => {
            console.log('Registration data:', this.form.value);
            this.showSuccess = true;

            // Redirect to login after success
            setTimeout(() => {
                this.router.navigate(['/auth/login']);
            }, 2000);
        }, 1500);
    }

    // OAuth methods
    registerWithGitHub(): void {
        console.log('GitHub OAuth registration');
    }

    registerWithGoogle(): void {
        console.log('Google OAuth registration');
    }

    // Form getters
    get username() { return this.form.get('username'); }
    get email() { return this.form.get('email'); }
    get password() { return this.form.get('password'); }
    get confirmPassword() { return this.form.get('confirmPassword'); }
    get agreeTerms() { return this.form.get('agreeTerms'); }
}
