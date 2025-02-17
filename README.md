```mermaid
---
title : CI/CD GITHUB Actions
---
graph TD
    A[Push Code to GitHub] --> B[Trigger Github Actions Workflow]
    B --> C[Checkout Code]
    C --> D[Install BDD for Tests integration]
    D --> E[Execute Scripts for BDD]
    E --> F[Set Up Java]
    F --> G[Set Up SonarCLoud Package]
    G --> H[Set Up Maven Package]
    I --> J[Build and Analyse SonarCloud with Maven]
    J --> K[Run Unit Tests]
    K --> L[Run Integration Tests]
    L --> M[Upload Artefact]
    M --> N[Notify Team]
    O --> P[Download Artefact] 
    P --> Q[Build Docker Image for API Application]
    Q --> R[Push Docker Image to Registry]
    R --> S[Notify Team]
```