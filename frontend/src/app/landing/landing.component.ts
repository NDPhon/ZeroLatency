import { Component, OnInit, OnDestroy, HostListener, Inject, PLATFORM_ID } from '@angular/core';
import { RouterLink } from '@angular/router';
import { CommonModule, isPlatformBrowser } from '@angular/common';

@Component({
    selector: 'app-landing',
    standalone: true,
    imports: [RouterLink, CommonModule],
    templateUrl: './landing.component.html',
    styleUrl: './landing.component.css'
})
export class LandingComponent implements OnInit, OnDestroy {
    currentYear = new Date().getFullYear();
    isDarkMode = false;

    // Animated counters - start with base values to avoid showing 0
    discussionCount = 10000;
    memberCount = 10000;
    solutionCount = 7000;

    private targetDiscussions = 12453;
    private targetMembers = 12000;
    private targetSolutions = 8920;
    private animationDuration = 2000;
    private counterInterval: any;
    private isBrowser: boolean;

    constructor(@Inject(PLATFORM_ID) platformId: Object) {
        this.isBrowser = isPlatformBrowser(platformId);
    }

    ngOnInit() {
        if (this.isBrowser) {
            // Check for saved dark mode preference
            const savedTheme = localStorage.getItem('theme');
            if (savedTheme === 'dark') {
                this.isDarkMode = true;
                document.documentElement.classList.add('dark-mode');
            }

            // Start counter animation after a short delay
            setTimeout(() => this.animateCounters(), 500);

            // Initialize scroll animations
            this.initScrollAnimations();
        }
    }

    ngOnDestroy() {
        if (this.counterInterval) {
            clearInterval(this.counterInterval);
        }
    }

    toggleDarkMode() {
        this.isDarkMode = !this.isDarkMode;
        if (this.isDarkMode) {
            document.documentElement.classList.add('dark-mode');
            localStorage.setItem('theme', 'dark');
        } else {
            document.documentElement.classList.remove('dark-mode');
            localStorage.setItem('theme', 'light');
        }
    }

    private animateCounters() {
        const steps = 60;
        const stepDuration = this.animationDuration / steps;
        let currentStep = 0;

        this.counterInterval = setInterval(() => {
            currentStep++;
            const progress = this.easeOutQuad(currentStep / steps);

            this.discussionCount = Math.round(this.targetDiscussions * progress);
            this.memberCount = Math.round(this.targetMembers * progress);
            this.solutionCount = Math.round(this.targetSolutions * progress);

            if (currentStep >= steps) {
                clearInterval(this.counterInterval);
                this.discussionCount = this.targetDiscussions;
                this.memberCount = this.targetMembers;
                this.solutionCount = this.targetSolutions;
            }
        }, stepDuration);
    }

    private easeOutQuad(t: number): number {
        return t * (2 - t);
    }

    private initScrollAnimations() {
        const observerOptions = {
            threshold: 0.1,
            rootMargin: '0px 0px -50px 0px'
        };

        const observer = new IntersectionObserver((entries) => {
            entries.forEach(entry => {
                if (entry.isIntersecting) {
                    entry.target.classList.add('animate-in');
                }
            });
        }, observerOptions);

        // Observe all sections with animate-on-scroll class
        setTimeout(() => {
            document.querySelectorAll('.animate-on-scroll').forEach(el => {
                observer.observe(el);
            });
        }, 100);
    }

    formatNumber(num: number): string {
        if (num >= 1000) {
            return (num / 1000).toFixed(1) + 'K';
        }
        return num.toString();
    }
}
