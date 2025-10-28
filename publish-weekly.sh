#!/bin/bash

# CMD Football Weekly Publish Script
# Author: Mohamad
# Purpose: Automate weekly export, commit, and deployment

set -e

echo "📦 Starting weekly publish for CMD Football..."

# Step 1: Pull latest changes
echo "🔄 Syncing with remote repository..."
git pull origin main

# Step 2: Run backend export (CSV + PDF)
echo "🧮 Generating weekly reports..."
curl -s http://localhost:8080/api/export > weekly-squad.csv
curl -s http://localhost:8080/api/report/pdf --output weekly-report.pdf

# Step 3: Stage and commit new reports
echo "📁 Committing reports to Git..."
git add weekly-squad.csv weekly-report.pdf
git commit -m "📊 Weekly report published on $(date '+%Y-%m-%d')"

# Step 4: Push to GitHub
echo "🚀 Pushing to remote..."
git push origin main

# Step 5: Trigger Docker rebuild (optional)
echo "🐳 Rebuilding Docker container..."
docker build -t cmd-football-backend ./cmd-football-backend
docker stop cmd-football || true
docker rm cmd-football || true
docker run -d -p 8080:8080 --name cmd-football cmd-football-backend

echo "✅ Weekly publish complete!"