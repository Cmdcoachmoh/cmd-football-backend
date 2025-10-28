@echo off
REM CMD Football Weekly Publish Script (Windows)
REM Author: Mohamad
REM Purpose: Automate weekly export, commit, and deployment

echo 📦 Starting weekly publish for CMD Football...

REM Step 1: Sync with remote repository
echo 🔄 Pulling latest changes from Git...
git pull origin main

REM Step 2: Generate weekly reports
echo 🧮 Generating weekly CSV and PDF reports...
curl -s http://localhost:8080/api/export > weekly-squad.csv
curl -s http://localhost:8080/api/report/pdf --output weekly-report.pdf

REM Step 3: Commit new reports
echo 📁 Staging and committing reports...
git add weekly-squad.csv weekly-report.pdf
git commit -m "📊 Weekly report published on %DATE%"
git push origin main

REM Step 4: Rebuild and restart Docker container (optional)
echo 🐳 Rebuilding Docker container...
docker build -t cmd-football-backend .\cmd-football-backend
docker stop cmd-football
docker rm cmd-football
docker run -d -p 8080:8080 --name cmd-football cmd-football-backend

echo ✅ Weekly publish complete!
pause