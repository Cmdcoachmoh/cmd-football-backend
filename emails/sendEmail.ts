import path from 'path';
import ejs from 'ejs';
import sgMail from '@sendgrid/mail';
import dotenv from 'dotenv';

dotenv.config();
sgMail.setApiKey(process.env.SENDGRID_API_KEY!);

interface EmailData {
  to: string;
  subject: string;
  template: 'report' | 'welcome' | 'milestone';
  data: {
    playerName?: string;
    coachName?: string;
    milestone?: string;
    date?: string;
    downloadLink?: string;
    dashboardLink?: string;
    logoUrl: string;
    language: 'en' | 'fr';
  };
}

const sendEmail = async ({ to, subject, template, data }: EmailData): Promise<void> => {
  const templatePath = path.join(__dirname, 'templates', `${template}.ejs`);
  const html = await ejs.renderFile(templatePath, data) as string;

  const msg = {
    to,
    from: 'noreply@cmdfootball.ca',
    subject,
    html,
  };

  await sgMail.send(msg);
};

export default sendEmail;